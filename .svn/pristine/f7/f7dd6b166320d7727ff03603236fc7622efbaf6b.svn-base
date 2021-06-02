package kr.happyjob.study.common.filter;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxSessionTimeoutFilter implements Filter {

	private String ajaxHeader;
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if (isAjaxRequest(req)) {
			try {
				chain.doFilter(req, res);
			} catch (AccessDeniedException e) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
			} catch (AuthenticationException e) {
				res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}
		} else {
			chain.doFilter(req, res);
		}
	}

	private boolean isAjaxRequest(HttpServletRequest req) {
		return req.getHeader(ajaxHeader) != null && req.getHeader(ajaxHeader).equals(Boolean.TRUE.toString());
	}
	
	public void init(FilterConfig filterConfig) {	}
	
    public void destroy() {}
}
