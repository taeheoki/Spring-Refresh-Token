package shop.taeheoki.refreshtoken.core.rds;

import lombok.Getter;

@Getter
public class AccessTokenResponse {

    private String accessToken;

    public AccessTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
