package com.mingi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.web.servlet.function.RouterFunctions.route; // 정적 임포트

import com.mingi.handlerfn.PersonFormHandler;
import com.mingi.handlerfn.PersonHandler;
import com.mingi.interceptor.CustomInterceptor;

@Configuration
@EnableWebMvc  // 웹 관련 설정 활성화
@ComponentScan(basePackages = {"com.mingi.controller", "com.mingi.handlerfn", "com.mingi.interceptor"})  // 컨트롤러 스캔
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }   
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("extras/home");  // 빈 경로 매핑
        registry.addViewController("/about").setViewName("extras/about");  // "/about" 경로 매핑
    }

    // 추가적인 설정: Default Servlet Handler
    @Override
    public void configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // 기본 서블릿 핸들링 활성화
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // JSON 메시지 컨버터 추가
        converters.add(new MappingJackson2HttpMessageConverter());
        
        converters.add(new ResourceHttpMessageConverter());        

    }
    
    @Bean
    public RouterFunction<ServerResponse> personRoutes(PersonHandler handler) {
    	return route().GET("/person/{id}", handler::getPerson)
    			.GET("/people", handler::listPeople)
    			.POST("/person", handler::createPerson)
    			.build();
    }
    
	@Bean
    public RouterFunction<ServerResponse> routerFunction(PersonFormHandler personFormHandler) {
    	return route().GET("/person-form", personFormHandler::renderPersonForm).build();
    }
	
	
	// 인터셉터 테스트 ////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
    private CustomInterceptor customInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // initbinder 경로에 대해 인터셉터를 적용 (모두는 /**)
        registry.addInterceptor(customInterceptor)
                .addPathPatterns("/initbinder/*");
    }
    
}