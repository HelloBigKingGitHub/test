package com.hl.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hl.entity.Userinfo;

/**
 * 
 * <p>
 * Title: LoginInterceptor
 * </p>
 * <p>
 * Description: 登录拦截器实现
 * </p>
 * 
 * @author huangliang
 * @date 2019年4月20日    HandlerInterceptor
 */
public class LoginInterceptor implements HandlerInterceptor {
	private static Logger logger = Logger.getLogger(LoginInterceptor.class);

	/**
	 * 在业务请求之前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("==============执行顺序: 1、preHandle================");
		String requestUri = request.getRequestURI();
		//String contextPath = request.getContextPath();
		//String url = requestUri.substring(contextPath.length());
		if (requestUri.contains("login.action") || requestUri.contains("reg.action")
				|| requestUri.contains("user_code.action") || requestUri.contains("user_phoneCode.action") ) {
			logger.info("Interceptor：请求路径"+requestUri);
			return true;
		} else {
			logger.info("Interceptor：请求路径"+requestUri);
			Userinfo user = (Userinfo) request.getSession().getAttribute("crruentUser");
			if (user == null) {
				logger.info("Interceptor：跳转到login页面！");
				redirect(request, response);
				return false;
			} else
				return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

	  //对于请求是ajax请求重定向问题的处理方法
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            //告诉ajax我是重定向
        	logger.info("Interceptor：是AJAX请求！");
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", basePath+"/log_reg.jsp");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
        	logger.info("Interceptor：不是AJAX请求！");
            response.sendRedirect(basePath + "/log_reg.jsp");
        }
    }


	

}
