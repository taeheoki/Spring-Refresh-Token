package shop.taeheoki.refreshtoken.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.taeheoki.refreshtoken.core.annotation.LoginMemberId;
import shop.taeheoki.refreshtoken.model.MemberRequest;
import shop.taeheoki.refreshtoken.model.MemberResponse;
import shop.taeheoki.refreshtoken.service.MemberService;

import java.net.URI;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody MemberRequest request) {
        Long memberId = memberService.createMember(request);
        log.info("memberId={}", memberId);
        return ResponseEntity.created(URI.create("/member/" + memberId)).build();
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponse> findMe(@LoginMemberId Long loginMemberId) {
        MemberResponse memberResponse = memberService.getMemberById(loginMemberId);
        return ResponseEntity.ok(memberResponse);
    }
}
