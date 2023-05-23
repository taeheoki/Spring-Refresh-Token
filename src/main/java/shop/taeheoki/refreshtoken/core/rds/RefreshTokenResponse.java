package shop.taeheoki.refreshtoken.core.rds;

import lombok.Getter;

@Getter
public class RefreshTokenResponse {

    private String refreshToken;

    public RefreshTokenResponse(RefreshToken refreshToken) {
        this.refreshToken = refreshToken.getRefreshToken();
    }
}
