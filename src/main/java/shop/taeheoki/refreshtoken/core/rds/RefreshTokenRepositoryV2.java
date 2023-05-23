//package shop.taeheoki.refreshtoken.core.rds;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Repository;
//
//import java.util.Objects;
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//@Repository
//@RequiredArgsConstructor
//public class RefreshTokenRepositoryV2 {
//
//    private final RedisTemplate redisTemplate;
//
//    public void save(RefreshToken refreshToken) {
//        ValueOperations<String, Long> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set(refreshToken.getRefreshToken(), refreshToken.getMemberId());
//        redisTemplate.expire(refreshToken.getRefreshToken(), 60L, TimeUnit.SECONDS);
//    }
//
//    public Optional<RefreshToken> findById(String refreshToken) {
//        ValueOperations<String, Long> valueOperations = redisTemplate.opsForValue();
//        Long memberId = valueOperations.get(refreshToken);
//
//        if (Objects.isNull(memberId)) {
//            return Optional.empty();
//        }
//
//        return Optional.of(new RefreshToken(refreshToken, memberId));
//    }
//}
