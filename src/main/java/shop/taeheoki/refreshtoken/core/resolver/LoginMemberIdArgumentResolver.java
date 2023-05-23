package shop.taeheoki.refreshtoken.core.resolver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import shop.taeheoki.refreshtoken.core.annotation.LoginMemberId;
import shop.taeheoki.refreshtoken.core.jwt.MyJwtProvider;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginMemberIdArgumentResolver implements HandlerMethodArgumentResolver {

    private final MyJwtProvider myJwtProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginMemberId.class)
                && parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String accessToken = webRequest.getHeader("Authorization").split(" ")[2];
        log.info("accessToken={}", accessToken);
        return myJwtProvider.extractMemberId(accessToken);
    }

}
