package com.intimetec.restaurant.request.login;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.intimetec.restaurant.entity.User;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/Home" })
public class UserAuthentication implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Authenticator authenticator = new Authenticator();

		String username = (String) request.getParameter("username");

		String password = (String) request.getParameter("password");

		User logInUser = new User();
		logInUser.setUsername(username);
		logInUser.setPassword(password);

		User user = authenticator.userAuthenticator(logInUser);

		if (user != null) {
			request.setAttribute("user", user);
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher("/login_jsp/login.jsp").forward(request, response);
		}
	}

	public void destroy() {
	}

}
