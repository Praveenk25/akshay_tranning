package com.intimetec.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.service.UserService;
import com.intimetec.restaurant.service.impl.UserServiceImpl;

@WebServlet("/p/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();

		UserService userService = new UserServiceImpl();

		user.setFullName(request.getParameter("fullName"));
		user.setMobileNumber(request.getParameter("mobileNumber"));
		user.setPassword(request.getParameter("password"));
		user.setUsername(request.getParameter("username"));

		String userRole = request.getParameter("userRole");

		String result = userService.addUser(user, userRole);

		request.setAttribute("result", result);
		if (result != null) {
			request.getRequestDispatcher("/result_jsp/result.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] listOfUsernameToBeDeleted = request.getParameterValues("username");

		if (listOfUsernameToBeDeleted != null) {
			UserService userService = new UserServiceImpl();

			String result = userService.deleteUser(listOfUsernameToBeDeleted);
			request.setAttribute("result", result);
			if (result != null) {
				request.getRequestDispatcher("/result_jsp/result.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);

			}

		} else {
			request.getRequestDispatcher("/p/DeleteUserJsp").forward(request, response);

		}

	}

}
