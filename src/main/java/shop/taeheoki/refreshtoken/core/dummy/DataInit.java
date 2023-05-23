package shop.taeheoki.refreshtoken.core.dummy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import shop.taeheoki.refreshtoken.model.Member;
import shop.taeheoki.refreshtoken.model.MemberRepository;


@Component
public class DataInit{

    @Bean
    CommandLineRunner init(MemberRepository memberRepository){
        return args -> {
            Member taeheoki = new Member("taeheoki@naver.com", "김태헌", "1234");
            Member taeheoki2 = new Member("taeheoki2@naver.com", "김태헌", "1234");
            Member taeheoki3 = new Member("taeheoki3@naver.com", "김태헌", "1234");
            memberRepository.save(taeheoki);
            memberRepository.save(taeheoki2);
            memberRepository.save(taeheoki3);
        };
    }
}
