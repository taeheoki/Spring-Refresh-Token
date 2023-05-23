package shop.taeheoki.refreshtoken.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_tb")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    @Column(unique = true)
    private String email;
    private String name;
    private String password;

    public Member(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
