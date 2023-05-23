package shop.taeheoki.refreshtoken.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.taeheoki.refreshtoken.model.Member;
import shop.taeheoki.refreshtoken.model.MemberRepository;
import shop.taeheoki.refreshtoken.model.MemberRequest;
import shop.taeheoki.refreshtoken.model.MemberResponse;
import shop.taeheoki.refreshtoken.core.exception.NoSuchMemberException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long createMember(MemberRequest request) {
        Member member = new Member(request.getEmail(), request.getName(), request.getPassword());
        return memberRepository.save(member).getId();
    }

    public MemberResponse getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(NoSuchMemberException::new);

        return new MemberResponse(member);
    }
}
