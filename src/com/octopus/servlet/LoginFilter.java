package com.octopus.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.octopus.entity.Employee;

/**
 * 防止非法登录
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 获取Session

		// 强制类型转换
		HttpServletRequest hsq = (HttpServletRequest) request;
		HttpSession session = hsq.getSession();

		// 获取当前登录用户信息
		Employee emp = (Employee) session.getAttribute("empl");

		// 获取请求URI
		String uri = hsq.getRequestURI();

		if (uri.contains("/resources")) {
			chain.doFilter(request, response);
		} else if (uri.contains("/login")) {
			chain.doFilter(request, response);
		} else if (emp != null) {
			chain.doFilter(request, response);
		} else {
			hsq.getRequestDispatcher("/login.jsp").forward(hsq, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}