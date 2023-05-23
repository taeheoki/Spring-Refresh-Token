package shop.taeheoki.refreshtoken.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import shop.taeheoki.refreshtoken.core.jwt.MyJwtProvider;
import shop.taeheoki.refreshtoken.core.resolver.LoginMemberIdArgumentResolver;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final MyJwtProvider myJwtProvider;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberIdArgumentResolver(myJwtProvider));
    }
}
