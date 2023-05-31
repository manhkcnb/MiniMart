/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import models.Category;
import context.ConnectDb;
/**
 *
 * @author TT
 */
public class CategoryDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Category getCategoryById(int id){
        Category a = null;
        String query = "SELECT * FROM category WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                a = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }catch(Exception e){
            
        }
        return a;
    }
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM category";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public static void main(String[] args) {
        CategoryDao dao = new CategoryDao();
        List<Category> list = dao.getAllCategory();
        for(Category x : list){
            System.out.println(x);
        }
    }
}
