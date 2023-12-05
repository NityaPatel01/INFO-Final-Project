/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import model.Order;

/**
 * Database Connector class for interacting with database
 * @author Nitya
 */
public class Orderjava {

    private static final String URL = "jdbc:mysql://localhost:3307/test_database?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Privatized constructor so as to not allow object creation
     */
    private Orderjava() {
    }

    /**
     * Insert given user to database
     * @see User
     * @param user User object to be added
     */
    public static void addorder(Order order) {
        //add to database
        String query = "INSERT INTO Order(ORDERID,CREATORID,PRODUCTNAME,ADDRESS,PLACEDATE,AGENTID,STATUS,NOTES) VALUES(?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,order.getOrderid());
            stmt.setInt(2, order.getCreatorid());
            stmt.setString(3, order.getProductname());
            stmt.setString(4, order.getAddress());
            stmt.setString(5, order.getPlacedate());
            stmt.setInt(6, order.getAgentid());
            stmt.setString(7, order.getOrderstatus());
            stmt.setString(8, order.getNotes());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return lost of all users in database
     * @see User
     * @return list of users
     */
    public static ArrayList<Order> getAllorders() {
//        return list of users from db
        ArrayList<Order> orders = new ArrayList<>();

        String query = "SELECT * FROM Order";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Order o = new Order();
                o.setOrderid(rs.getInt("ORDERID"));
                o.setCreatorid(rs.getInt("CREATORID"));
                o.setProductname(rs.getString("PRODUCTNAME"));
                o.setAddress(rs.getString("ADDRESS"));
                o.setPlacedate(rs.getString("PLACEDATE"));
                o.setAgentid(rs.getInt("AGENTID"));
                o.setOrderstatus(rs.getString("STATUS"));
                o.setNotes(rs.getString("NOTES"));
                orders.add(o);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
   }
    
     public static void editorder(Order oldorder, Order neworder) {
        String query = "UPDATE Order SET STATUS=? WHERE ORDERID=?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setInt(1, oldorder.getOrderid());
             stmt.setInt(2, oldorder.getCreatorid());
             stmt.setString(3, oldorder.getProductname());
             stmt.setString(4, oldorder.getAddress());
             stmt.setString(5, oldorder.getPlacedate());
             stmt.setInt(6, oldorder.getAgentid());
             stmt.setString(7, neworder.getOrderstatus());
             stmt.setString(8, oldorder.getNotes());
//            stmt.setString(1, newUser.getName());
//            stmt.setInt(2, newUser.getAge());
//            stmt.setInt(3, oldUser.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete given user from database
     * @see User
     * @param u User to be deleted
     * 
     */
//    public static void deleteUser(User u) {
//        String query = "delete from User where id = ?";
//
//        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
//            PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setInt(1, u.getId());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Edit given user details in the database
     * @param oldUser existing user in database
     * @param newUser modified user details to be added
     */
//   
}
