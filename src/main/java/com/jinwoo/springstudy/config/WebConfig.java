package com.jinwoo.springstudy.config;

import com.jinwoo.springstudy.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) { // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 add를 통해서 추가
        argumentResolvers.add(loginUserArgumentResolver);
    }
}