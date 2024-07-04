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

@WebServlet("/AddOrderForm")
public class AddOrderForm extends HttpServlet {
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
        out.println("<h2>Add Order Details</h2>");
        out.println("<form action='AddOrderCont' method='post'>");
        out.println("Customer ID: <input type='text' name='customer_id'><br/><br/>");
        out.println("Order Date: <input type='datetime-local' name='order_date'><br/><br/>");
        out.println("Total Amount: <input type='text' name='total_amount'><br/><br/>");
        out.println("Status: <input type='text' name='status'><br/><br/>");
        out.println("<input type='submit' name='Submit'>");
        out.println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}