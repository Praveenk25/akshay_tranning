package com.intimetec.restaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intimetec.restaurant.entity.MenuItem;
import com.intimetec.restaurant.service.MenuItemService;
import com.intimetec.restaurant.service.impl.MenuItemServiceImpl;

@WebServlet("/p/MenuItemController")
public class MenuItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestType = request.getParameter("requestType");

		MenuItemService menuItemService = new MenuItemServiceImpl();

		String result = null;

		if (requestType.equalsIgnoreCase("delete")) {
			String[] listOfItemNameToBeDeleted = request.getParameterValues("itemName");

			if (listOfItemNameToBeDeleted != null) {

				result = menuItemService.deleteMenuItem(listOfItemNameToBeDeleted);
			} else {
				MenuItem menuItem = new MenuItem();

				menuItem.setItemName(request.getParameter("itemName"));
				menuItem.setPrice(Float.parseFloat(request.getParameter("price")));

				String avail = request.getParameter("available");
				if (avail.equals("yes")) {
					menuItem.setAvailable(true);
				} else {
					menuItem.setAvailable(false);
				}

				if (requestType.equalsIgnoreCase("add")) {
					result = menuItemService.addMenuItem(menuItem);
				} else {
					result = menuItemService.updateItem(menuItem);
				}

			}

			request.setAttribute("result", result);
			if (result != null) {
				request.getRequestDispatcher("/result_jsp/result.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/error_jsp/error.jsp").forward(request, response);

			}
		}

	}
}
