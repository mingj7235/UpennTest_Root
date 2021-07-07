package com.joshua.config.auth;

import com.joshua.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

//HandlerMethodArgumentResolver를 구현한 클래스.

/**
 * HandlerMethodArgumentResolver는 한가지 기능을 지원한다. 조건에 맞는 경우 메소드가 있다면 HandlerMethodArgumentResolver의
 * 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있다.
 *
 * 이 클래스가 스프링에서 인식할 수 있도록 하기 위해 config에 WebConfig 클래스를 생성한다.
 */

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //컨트롤러 메소드의 특정 파라미터를 지원하는지 판단한다.
        //파라미터에 @LoginUser 어노테이션이 붙어있고, 파라미터 클래스 타입이 SessionUser.class인 경우 true를 반환한다.

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //파라미터에 전달할 객체를 생성한다.
        //여기서는 세션에서 객체를 가져온다.

        return httpSession.getAttribute("user");
    }
}
