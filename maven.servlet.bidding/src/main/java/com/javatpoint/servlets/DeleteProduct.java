package com.javatpoint.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.dao.ProductDao;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao.delete(request.getParameter("itemno"));
		response.sendRedirect("ViewProduct");
	}
}
