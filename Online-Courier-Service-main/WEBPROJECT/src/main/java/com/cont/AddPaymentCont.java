package com.cont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPaymentCont")
@MultipartConfig(maxFileSize = 161772150) // Max size for file upload
public class AddPaymentCont extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String url = "jdbc:mysql://localhost:3306/vsbdb";
    private String user = "root";
    private String password = "root";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int orderId = Integer.parseInt(request.getParameter("order_id"));
        Timestamp paymentDate = Timestamp.valueOf(request.getParameter("payment_date"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("payment_method");

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
            } else {
                msg = "Failed to add payment";
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            msg = "Error occurred while adding payment";
        }

        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/Success.html").forward(request, response);
    }
}