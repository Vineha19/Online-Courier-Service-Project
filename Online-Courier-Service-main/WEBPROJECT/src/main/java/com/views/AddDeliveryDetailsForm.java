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

@WebServlet("/AddDeliveryDetailsForm")
public class AddDeliveryDetailsForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("errors");

		out.println("<html>");
		out.println("<body>");
		if (list != null) {
			Iterator<String> itr = list.iterator();
			out.println("<ul>");
			while (itr.hasNext()) {
				out.println("<li>" + itr.next() + "</li>");
			}
			out.println("</ul>");
		}
		out.println("<h2>Add Delivery Details</h2>");
		out.println("<form action='AddDeliveryDetailsCont' method='post' enctype='multipart/form-data'>");
		out.println("Order ID<input type='text' name='order_id'><br/><br/>");
		out.println("Delivery Date<input type='text' name='delivery_date'><br/><br/>");
		out.println("Delivery Address<input type='text' name='delivery_address'><br/><br/>");
		out.println("Delivery Status<input type='text' name='delivery_status'><br/><br/>");
		out.println("<input type='submit' name='Submit'>");
		out.println("</form></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}