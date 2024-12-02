package com.mingi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomInterceptor implements HandlerInterceptor {

    // 컨트롤러 실행 전에 호출
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("인터셉터: 요청 전에 실행됩니다.");
        
        // true를 반환하면 요청이 계속 진행되고, false를 반환하면 요청을 중단합니다.
        return true;
    }

    // 컨트롤러 실행 후, 뷰 렌더링 전 호출
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("인터셉터: 컨트롤러 실행 후에 실행됩니다.");
    }

    // 뷰 렌더링 후 호출 (예외 발생 여부와 관계없이 실행)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("인터셉터: 뷰 렌더링 후에 실행됩니다.");
    }
}