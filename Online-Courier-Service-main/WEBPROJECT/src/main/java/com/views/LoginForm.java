package com.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginForm")

public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list=(ArrayList<String>) request.getAttribute("errors");
		
		out.println("<html>");
		out.println("<body>");
		if(list!=null) {
			Iterator<String> itr=list.iterator();
			out.println("<ul>");
			while(itr.hasNext()) {
			out.println("<li>"+itr.next()+"</li>");
		}
		out.println("</ul>");
		}
		out.println("<h2> </h2>");
		out.println("<form action='SignupCont' method='post'>");
		out.println("Username<input type='text' name='username'><br/><br/>");
		out.println("Password<input type='text' name='password'><br/><br/>");
		out.println("<input type='submit' name='Submit'>");
		out.println("</form></body></html>");
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	

	}

}