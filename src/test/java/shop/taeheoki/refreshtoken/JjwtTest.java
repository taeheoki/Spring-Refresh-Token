package shop.taeheoki.refreshtoken;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;


public class JjwtTest {

    @DisplayName("jjwt를 사용해서 유효한 JWT를 생성하고 검증합니다.")
    @Test
    public void jjwtTest() throws Exception {
        Claims claims = Jwts.claims();
        claims.setSubject("taeheoki");
        Date iat = new Date();
        claims.setIssuedAt(iat);
        Date exp = new Date(iat.getTime() + 1000 * 60 * 60 * 24);
        claims.setExpiration(exp);
        String random256BitKey = "6v9y$B&E)H@MbQeThWmZq4t7w!z%C*F-";
        SecretKey secretKey = Keys.hmacShaKeyFor(random256BitKey.getBytes());
        JwtParser parser = Jwts.parserBuilder().setSigningKey(secretKey).build();

        String jws = Jwts.builder()
                .setClaims(claims)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        Jws<Claims> claimsJws = parser.parseClaimsJws(jws);

        assertThat(claimsJws.getBody().getSubject()).isEqualTo("taeheoki");
        assertThat(claimsJws.getBody().getExpiration().before(iat)).isFalse();
    }
}
