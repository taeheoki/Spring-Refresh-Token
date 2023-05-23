package shop.taeheoki.refreshtoken.core.rds;

import lombok.Getter;

@Getter
public class RefreshTokenRequest {

    private String email;
    private String password;
}
