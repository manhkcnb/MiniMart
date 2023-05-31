/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import models.Order;

/**
 *
 * @author TT
 */
public class OrderDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Order> getAllOrder(){
        String query = "SELECT * FROM `order`";
        List<Order> list = new ArrayList<>();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public Order getOrderByCart(int id){
        String query = "SELECT * FROM `order` WHERE cart_id = ?";
        CartDao dao = new CartDao();
        int cartId = dao.getCartByUser(id).getId();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartId);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public Order getOrderById(int id){
        String query = "SELECT * FROM `order` WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Order(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public void addOrderByUser(int userId, String receiver, String address, String phone, String status, String note){
        String query = "INSERT INTO `order`(`cart_id`, `receiver`, `address`, `phone`, `note`, `status`) VALUES (?,?,?,?,?,?)";
        CartDao dao = new CartDao();
        int cartId = dao.getCartByUser(userId).getId();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartId);
            ps.setString(2, receiver);
            ps.setString(3, address);
            ps.setString(4, phone);
            ps.setString(5, note);
            ps.setString(6, status);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void acceptOrder(int id){
        String query = "UPDATE `order` SET `status`= ? WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "Đã xác nhận !");
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
}
