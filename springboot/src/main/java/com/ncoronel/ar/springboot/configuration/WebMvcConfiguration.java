package com.ncoronel.ar.springboot.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ncoronel.ar.springboot.component.RequestTimeIntercept;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	
	@Autowired
	@Qualifier("requestTimeIntercept")
	private RequestTimeIntercept requestTimeIntercept;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeIntercept);
	}

	

}
