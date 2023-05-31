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
import models.Cart;
import models.CartItem;

/**
 *
 * @author TT
 */
public class CartDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Cart getCartByUser(int id){
        String query = "SELECT * FROM `cart` WHERE user_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public void createCart(int userId){
        String query = "INSERT INTO `cart`(`user_id`, `totalPrice`) VALUES (?,?)";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, 0);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void saveCart(int userId, int totalPrice){
        String query = "UPDATE `cart` SET `totalPrice`= ?  WHERE user_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, totalPrice);
            ps.setInt(2, userId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        
    }
    public void addToCart(int productId, int cartId){
        String query = "INSERT INTO `cart_item`(`product_id`, `count`, `cart_id`) VALUES (?,?,?)";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, 1);
            ps.setInt(3, cartId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void updateCartItem(int productId, int cartId, int count){
        String query = "UPDATE `cart_item` SET `count`= ? WHERE product_id = ? AND cart_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, count);
            ps.setInt(2, productId);
            ps.setInt(3, cartId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void deleteCartItem(int itemId, int cartId){
        String query = "DELETE FROM `cart_item` WHERE id = ? AND cart_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, itemId);
            ps.setInt(2, cartId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        
    }
    public CartItem getCartItemByProductAndCart(int productId, int cartId){
        String query = "SELECT * FROM `cart_item` WHERE product_id = ? AND cart_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, cartId);
            rs = ps.executeQuery();
            while(rs.next()){
                return new CartItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public List<CartItem> getListCartItemByCart(int cartId){
        String query = "SELECT * FROM `cart_item` WHERE cart_id = ?";
        List<CartItem> list = new ArrayList<>();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cartId);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new CartItem(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public static void main(String[] args) {
        CartDao dao = new CartDao();
        dao.createCart(5);
    }
}
