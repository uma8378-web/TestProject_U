package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.ProductBean;
import com.javatpoint.dao.ProductDao;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Product</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navseller.html").include(request, response);
		
		out.println("<div class='container'>");
		String itemno=request.getParameter("itemno");
		String name=request.getParameter("name");
		String squantity=request.getParameter("quantity");
		String sprice=request.getParameter("price");
	//	String soldout1=request.getParameter("soldout");
		int quantity=Integer.parseInt(squantity);
		int price=Integer.parseInt(sprice);
	//	int soldout=Integer.parseInt(soldout1);
		ProductBean bean= new ProductBean(itemno,name,quantity,price);
		int i=ProductDao.save(bean);
		if(i>0){
			out.println("<h3>Product saved successfully</h3>");
		}
		request.getRequestDispatcher("addproductform.html").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
