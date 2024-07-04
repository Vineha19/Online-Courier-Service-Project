package com.views;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPaymentForm")
public class AddPaymentForm extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String url = "jdbc:mysql://localhost:3306/vsbdb";
    String user = "root";
    String password = "root";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Add Payment Details </h2>");
        out.println("<form action='AddPaymentForm' method='post'>");
        out.println("Order ID<input type='text' name='order_id'><br/><br/>");
        out.println("Payment Date<input type='text' name='payment_date'><br/><br/>");
        out.println("Amount<input type='text' name='amount'><br/><br/>");
        out.println("Payment Method<input type='text' name='payment_method'><br/><br/>");
        out.println("<input type='submit' name='Submit'>");
        out.println("</form></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIdStr = request.getParameter("order_id");
        String paymentDateStr = request.getParameter("payment_date");
        String amountStr = request.getParameter("amount");
        String paymentMethod = request.getParameter("payment_method");

        int orderId = Integer.parseInt(orderIdStr);
        Timestamp paymentDate = Timestamp.valueOf(paymentDateStr);
        double amount = Double.parseDouble(amountStr);

        Connection con = null;
        PreparedStatement pst = null;
        String msg = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Payments (order_id, payment_date, amount, payment_method) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            pst.setTimestamp(2, paymentDate);
            pst.setDouble(3, amount);
            pst.setString(4, paymentMethod);
            int res = pst.executeUpdate();
            if (res > 0) {
                msg = "Payment added successfully";
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            msg = "Error occurred while adding the payment";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>" + msg + "</h2>");
        out.println("<a href='AddPaymentForm'>Add another payment</a>");
        out.println("</body></html>");
    }
}