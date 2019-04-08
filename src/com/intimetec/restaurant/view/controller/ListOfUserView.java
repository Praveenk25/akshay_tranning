package com.intimetec.restaurant.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.service.UserService;
import com.intimetec.restaurant.service.impl.UserServiceImpl;

@WebServlet("/p/ListOfUserView")
public class ListOfUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();

		ArrayList<User> userList = userService.getUserList();

		if (userList != null) {
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("/user_jsp/viewUser.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);
		}
	}
}
