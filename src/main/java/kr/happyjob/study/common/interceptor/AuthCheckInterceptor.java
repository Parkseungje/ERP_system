package kr.happyjob.study.common.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

	// Set logger 
		private final Logger logger = LogManager.getLogger(this.getClass());
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession(false);
		if (session != null) {
			
			String requestUri = request.getRequestURI();
			
			//System.out.println("request.getContextPath() " + request.getContextPath());
			 
			if ("/".equals(requestUri)) {
				
				logger.info("root path in");
				
				response.sendRedirect(request.getContextPath() + "/dashboard/dashboard.do");
				response.flushBuffer();
				
				return false;
			}
			
			Object authInfo = session.getAttribute("usrMnuAtrt");
			if (authInfo != null) {
				return true;
			}
		}
		
		
		String ajaxCall = (String) request.getHeader("AJAX");
		if ("true".equals(ajaxCall)) {
			response.sendError(901);
		} 
		return true;
	}
}
