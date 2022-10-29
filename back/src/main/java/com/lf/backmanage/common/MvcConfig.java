package com.lf.backmanage.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 添加jwt拦截器，并指定拦截路径
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/user/login");
    }

    /**
     * jwt拦截器
     * */
   // @Bean
   // public JwtInterceptor jwtInterceptor() {
   //     return new JwtInterceptor();
   /// }

}
