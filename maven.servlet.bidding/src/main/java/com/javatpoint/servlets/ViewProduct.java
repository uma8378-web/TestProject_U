package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.ProductBean;
import com.javatpoint.beans.BidderBean;
import com.javatpoint.dao.ProductDao;
import com.javatpoint.dao.BidderDao;
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Product</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navseller.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<ProductBean> list=ProductDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		
		out.println("<tr><th>Itemno</th><th>Name</th><th>Quantity</th><th>Price</th><th>Sold</th><th>Bid</th><th>Delete</th></tr>");
		for(ProductBean bean:list){
			out.println("<tr><td>"+bean.getItemno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getPrice()+"</td><td>"+bean.getSoldout()+"</td><td><a href='BidProductForm?itemno="+bean.getItemno()+"'>Bid</a></td><td><a href='DeleteProduct?itemno="+bean.getItemno()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
