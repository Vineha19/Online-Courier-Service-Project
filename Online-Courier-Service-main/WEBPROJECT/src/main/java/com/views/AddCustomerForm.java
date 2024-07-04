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

@WebServlet("/AddCustomerForm")
public class AddCustomerForm extends HttpServlet {
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
        out.println("<h2>Add Customer Details</h2>");
        out.println("<form action='AddCustomerCont' method='post'>");
        out.println("First Name: <input type='text' name='firstName'><br/><br/>");
        out.println("Last Name: <input type='text' name='lastName'><br/><br/>");
        out.println("Email: <input type='email' name='email'><br/><br/>");
        out.println("Phone: <input type='text' name='phone'><br/><br/>");
        out.println("Address: <textarea name='address'></textarea><br/><br/>");
        out.println("<input type='submit' name='Submit'>");
        out.println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}