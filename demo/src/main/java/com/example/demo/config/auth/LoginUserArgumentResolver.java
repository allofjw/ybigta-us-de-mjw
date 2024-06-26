package com.example.demo.config.auth;

import com.example.demo.config.auth.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        boolean isLoginUserAnnotation=
                parameter.getMethodAnnotation(LoginUser.class)!=null;//@LoginUser 어노테이션 체크
        boolean isUserClass= SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;

    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {
        return httpSession.getAttribute("user");

    }
}
