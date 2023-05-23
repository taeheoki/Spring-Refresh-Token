package shop.taeheoki.refreshtoken.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {
    private String email;
    private String name;
    private String password;

    public MemberResponse(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.password = member.getPassword();
    }
}
