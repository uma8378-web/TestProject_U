package com.javatpoint.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.BidderBean;
import com.javatpoint.dao.BidderDao;
@WebServlet("/EditBidder")
public class EditBidder extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String postal=request.getParameter("postal");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		BidderBean bean=new BidderBean(id, name, email, postal, mobile);
		BidderDao.update(bean);
		response.sendRedirect("ViewBidder");
	}

}
