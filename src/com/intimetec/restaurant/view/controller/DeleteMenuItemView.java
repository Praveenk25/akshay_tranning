package com.intimetec.restaurant.view.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.restaurant.entity.MenuItem;
import com.intimetec.restaurant.service.MenuItemService;
import com.intimetec.restaurant.service.impl.MenuItemServiceImpl;

@WebServlet("/deleteMenuItemView")
public class DeleteMenuItemView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MenuItemService menuItemService = new MenuItemServiceImpl();

		ArrayList<MenuItem> menuItemList = menuItemService.getMenuItemList();

		if (menuItemList != null) {
			System.out.println(menuItemList);
			request.setAttribute("menuItemList", menuItemList);
			request.getRequestDispatcher("/menuItem_jsp/deleteMenuItem.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);
		}

	}

}
