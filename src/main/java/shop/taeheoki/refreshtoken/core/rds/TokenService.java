package shop.taeheoki.refreshtoken.core.rds;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.taeheoki.refreshtoken.core.exception.AuthException;
import shop.taeheoki.refreshtoken.core.exception.InvalidRefreshTokenException;
import shop.taeheoki.refreshtoken.core.jwt.MyJwtProvider;
import shop.taeheoki.refreshtoken.model.MemberRepository;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {

    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public RefreshTokenResponse generateRefreshToken(RefreshTokenRequest request) {
        Long memberId = memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(AuthException::new)
                .getId();

        RefreshToken refreshToken = new RefreshToken(UUID.randomUUID().toString(), memberId);
        refreshTokenRepository.save(refreshToken);
        return new RefreshTokenResponse(refreshToken);
    }

    public AccessTokenResponse generateAccessToken(AccessTokenRequest request) {
        RefreshToken refreshToken = refreshTokenRepository.findById(request.getRefreshToken())
                .orElseThrow(InvalidRefreshTokenException::new);
        Long memberId = refreshToken.getMemberId();

        String accessToken = MyJwtProvider.create(memberId);

        return new AccessTokenResponse(accessToken);
    }
}
