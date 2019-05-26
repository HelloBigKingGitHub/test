package com.hl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hl.entity.Userinfo;
import com.hl.interceptor.LoginInterceptor;

public class LoginFilter implements Filter{
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("==============登录过滤器初始化================");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("==============登录过滤器执行中================");
		 HttpServletRequest req = (HttpServletRequest) request;
	     HttpServletResponse res = (HttpServletResponse) response;
	     String contextPath = req.getContextPath();
	     String requestUri = req.getRequestURI();
	     if(requestUri.contains("login.action") || requestUri.contains("reg.action")
				|| requestUri.contains("user_code.action") || requestUri.contains("user_phoneCode.action")) {
	    	 logger.info("==============登录过滤器放行================");
	    	 chain.doFilter(req, res);
	     }else {
	    	 Userinfo user = (Userinfo) req.getSession().getAttribute("crruentUser");
	    	 if(user == null) {
	    		 logger.info("==============登录过滤器跳转================");
	    		 res.sendRedirect(contextPath+"/log_reg.jsp");
	    	 }else {
	    		 logger.info("==============登录过滤器放行================");
	    		 chain.doFilter(req, res);
	    	 }
	     }
		
	}

	@Override
	public void destroy() {
		logger.info("==============过滤器销毁================");
		
	}

}
