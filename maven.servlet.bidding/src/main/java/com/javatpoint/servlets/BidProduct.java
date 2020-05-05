package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.ProductBean;
import com.javatpoint.beans.BidProductBean;
import com.javatpoint.dao.BidderDao;
import com.javatpoint.dao.ProductDao;
@WebServlet("/BidProduct")
public class BidProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Bid Product Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navbidder.html").include(request, response);
		
		out.println("<div class='container'>");
		String itemno=request.getParameter("itemno");
		String name=request.getParameter("name");
		String sbidprice=request.getParameter("bidprice");
		int bidprice=Integer.parseInt(sbidprice);
		
		BidProductBean bean=new BidProductBean(itemno,name,bidprice);
		int i=ProductDao.Bid_Product(bean);
		int j=ProductDao.biddingStatus(bean);
		if(i>0 && j>0){
			out.println("<h3>Bid a product successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to bid a product.</h3><p> Kindly visit later.</p>");
		}
		response.sendRedirect("ViewProduct");
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
