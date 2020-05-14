package com.cts;

import javax.servlet.http.HttpServletRequest;



import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
 
	private  Logger logger = LogManager.getLogger(this.getClass());
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request=RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}",request,request.getRequestURI() );
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}
	

}
