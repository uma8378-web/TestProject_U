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
import com.javatpoint.beans.BidProductBean;
import com.javatpoint.dao.ProductDao;
@WebServlet("/ViewBiddingDetails")
public class ViewBiddingDetails extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Bidding Details</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navseller.html").include(request, response);
		
		out.println("<div class='container'>");
		
		List<BidProductBean> list=ProductDao.viewSoldoutProducts();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<h3> Bidding - Winner Details </h3>");
		out.println("<tr><th>itemno</th><th>Name</th><th>Bid Price</th><th>Bidder Id</th><th>Bid Date</th><th>Bidding Status</th></tr>");
		for(BidProductBean bean:list){
			out.println("<tr><td>"+bean.getItemno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getBidprice()+"</td><td>"+bean.getBidderid()+"</td><td>"+bean.getBiddate()+"</td><td>"+bean.getBiddingstatus()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
}
