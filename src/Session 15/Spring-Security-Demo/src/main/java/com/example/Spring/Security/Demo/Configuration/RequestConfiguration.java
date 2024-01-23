package com.example.Spring.Security.Demo.Configuration;

import com.example.Spring.Security.Demo.Interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RequestConfiguration implements WebMvcConfigurer {

    @Autowired
    private RequestInterceptor requestInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor)
                .addPathPatterns(
                        List.of(
                                "/users/allowedToAdmin",
                                "/users/allowedToUser"
                        )
                );
    }
}
