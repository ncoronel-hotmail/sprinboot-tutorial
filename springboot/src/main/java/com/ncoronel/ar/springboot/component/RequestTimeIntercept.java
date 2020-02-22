package com.ncoronel.ar.springboot.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("requestTimeIntercept")
public class RequestTimeIntercept extends HandlerInterceptorAdapter {
	
	private static final Log LOGGER = LogFactory.getLog(RequestTimeIntercept.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		
		LOGGER.info("REQUEST URL " + request.getRequestURL() + " TIME " + ( System.currentTimeMillis() - startTime) + "ms ");
	}


	
	

}
