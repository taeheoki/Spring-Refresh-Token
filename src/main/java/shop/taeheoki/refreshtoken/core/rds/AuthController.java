package shop.taeheoki.refreshtoken.core.rds;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;
    @PostMapping("/refresh-token")
    public ResponseEntity<RefreshTokenResponse> generateRefreshToken(@RequestBody RefreshTokenRequest refreshTokenRequestrequest, HttpServletRequest request) {

        RefreshTokenResponse refreshTokenResponse = tokenService.generateRefreshToken(refreshTokenRequestrequest);
        return ResponseEntity.ok(refreshTokenResponse);
    }

    @PostMapping("/access-token")
    public ResponseEntity<AccessTokenResponse> generateAccessToken(@RequestBody AccessTokenRequest request) {
        AccessTokenResponse accessTokenResponse = tokenService.generateAccessToken(request);
        return ResponseEntity.ok(accessTokenResponse);
    }
}
