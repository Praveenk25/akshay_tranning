package com.intimetec.restaurant.request.login;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.intimetec.restaurant.entity.RestaurantService;
import com.intimetec.restaurant.entity.User;
import com.intimetec.restaurant.service.UserService;
import com.intimetec.restaurant.service.impl.UserServiceImpl;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		UserService userService = new UserServiceImpl();

		User user = (User) request.getAttribute("user");

		session.setAttribute("user", user);

		ArrayList<RestaurantService> restaurantServiceForUser = userService.getUserServices(user);

		if (restaurantServiceForUser != null) {
			request.setAttribute("restaurantServiceForUser", restaurantServiceForUser);
			request.getRequestDispatcher("/home_jsp/home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);
		}

	}

}