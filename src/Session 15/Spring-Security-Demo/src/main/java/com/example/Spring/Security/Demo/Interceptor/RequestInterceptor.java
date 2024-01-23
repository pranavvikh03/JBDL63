package com.example.Spring.Security.Demo.Interceptor;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String encryptedCompanyName = request.getHeader("company");
        if(StringUtils.isBlank(encryptedCompanyName))
            throw new RuntimeException("Company should not be blank");

        System.out.println(String.format("Request URI: %s\n Request Method: %s\n Request Id: %s", request.getRequestURI(), request.getMethod(), request.getRequestId()));
        return true;
    }
}
