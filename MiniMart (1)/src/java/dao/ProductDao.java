/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import context.ConnectDb;
import models.Product;

/**
 *
 * @author TT
 */
public class ProductDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public int getTotalProduct(){
        int records = 0;
        String query = "SELECT COUNT(*) FROM product";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                records = rs.getInt(1);
            }
        }catch(Exception e){
            
        }
        return records;
    }
    public int getTotalProductByCategory(int id){
        int records = 0;
        String query = "SELECT COUNT(*) FROM product WHERE category_id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                records = rs.getInt(1);
            }
        }catch(Exception e){
            
        }
        return records;
    }
    public List<Product> getLastestProducts(int page){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` ORDER BY id DESC LIMIT ?, 5";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, page);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public List<Product> getProductsByCategory(int id, int page, int pageSize){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` WHERE category_id = ? LIMIT ?, ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, page);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public List<Product> sortProductByPrice(int cid, int page, int pageSize, String min, String max){
        List<Product> list = new ArrayList<>();
        String query1 = "SELECT * FROM `product` WHERE category_id = ? and price < ? ORDER BY price ASC LIMIT ?, ?";
        String query2 = "SELECT * FROM `product` WHERE category_id = ? and price >= ? and price < ? ORDER BY price ASC LIMIT ?, ?";
        String query3 = "SELECT * FROM `product` WHERE category_id = ? and price > ? ORDER BY price ASC LIMIT ?, ?";
        try{
            conn = new ConnectDb().getConnection();
            if(min == null){
                ps = conn.prepareStatement(query1);
                ps.setInt(1, cid);
                ps.setInt(2, Integer.parseInt(max));
                ps.setInt(3, page);
                ps.setInt(4, pageSize);
                rs = ps.executeQuery();
                while(rs.next()){
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
                }
            }else if(max == null){
                ps = conn.prepareStatement(query3);
                ps.setInt(1, cid);
                ps.setInt(2, Integer.parseInt(min));
                ps.setInt(3, page);
                ps.setInt(4, pageSize);
                rs = ps.executeQuery();
                while(rs.next()){
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
                }
            }else{
                ps = conn.prepareStatement(query2);
                ps.setInt(1, cid);
                ps.setInt(2, Integer.parseInt(min));
                ps.setInt(3, Integer.parseInt(max));
                ps.setInt(4, page);
                ps.setInt(5, pageSize);
                rs = ps.executeQuery();
                while(rs.next()){
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
                }
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public Product getProductById(int id){
        Product p = null;
        String query = "SELECT * FROM `product` WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            }
        }catch(Exception e){
            
        }
        return p;
    }
    public List<Product> searchProductByName(String name){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` WHERE productName LIKE ? LIMIT ?, ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%"+ name + "%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    // CRUD
    public void addProduct(Product product){
        String query = "INSERT INTO `product`"
                + "(`productName`, `productImg`, `price`, `description_1`, `description_2`, `description_3`, `origin`, `category_id`)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductImg());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getDescription_1());
            ps.setString(5, product.getDescription_2());
            ps.setString(6, product.getDescription_3());
            ps.setString(7, product.getOrigin());
            ps.setInt(8, product.getCategory_id());
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void deleteProduct(int id){
        String query = "DELETE FROM `product` WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public void updateProduct(int id, Product product){
        String query = "UPDATE `product` SET "
                + "`productName`= ?,`productImg`= ?,`price`= ?,`description_1`= ?,`description_2`= ?,`description_3`= ?,`origin`= ?,`category_id`= ? "
                + "WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getProductImg());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getDescription_1());
            ps.setString(5, product.getDescription_2());
            ps.setString(6, product.getDescription_3());
            ps.setString(7, product.getOrigin());
            ps.setInt(8, product.getCategory_id());
            ps.setInt(9, id);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public List<Product> getAllProduct(int page, int pageSize){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM `product` LIMIT ?, ?";
        int start = page * pageSize - pageSize;
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, start);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), 
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
}
