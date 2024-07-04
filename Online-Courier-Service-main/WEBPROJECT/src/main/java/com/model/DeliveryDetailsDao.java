package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryDetailsDao {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public DeliveryDetailsDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vsbdb", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void storeData(DeliveryDetails d) {
        String sql = "INSERT INTO DeliveryDetails (order_id, delivery_date, delivery_address, delivery_status) VALUES (?, ?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, d.getOrderId());
            pst.setString(2, d.getDeliveryDate());
            pst.setString(3, d.getDeliveryAddress());
            pst.setString(4, d.getDeliveryStatus());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet retrieveAllDeliveryDetails() {
        String sql = "SELECT * FROM DeliveryDetails";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet retrieveDeliveryDetailsById(int deliveryId) {
        String sql = "SELECT * FROM DeliveryDetails WHERE delivery_id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, deliveryId);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}