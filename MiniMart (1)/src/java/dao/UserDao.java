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
import models.Role;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author TT
 */
public class UserDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public User checkUserExist(String email){
        String query = "select * from user where email = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public void signUp(String userName, String password, String phone, String email){
        String query = "INSERT INTO `user`(`userName`, `password`, `phone`, `email`, `role_id`) VALUES (?, ?, ?, ?, ?)";
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, hash);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setInt(5, 1);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
    public User login(String email, String password){
        String query = "select * from user where email = ? and password = ?";
        UserDao dao = new UserDao();
        User user = dao.checkUserExist(email);
        String hashPassword = user.getPassword();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            if(BCrypt.checkpw(password, hashPassword)){
                ps.setString(2, hashPassword);
            }else{
                ps.setString(2, "wrong pass");
            }
            rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public Role getRoleById(int id){
        String query = "select * from role where id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Role(rs.getInt(1), rs.getString(2));
            }
        }catch(Exception e){
            
        }
        return null;
    }
    public List<User> getAllUsers(){
        String query = "select * from user";
        List<User> list = new ArrayList<>();
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
        }catch(Exception e){
            
        }
        return list;
    }
    public void deleteUser(int userId){
        String query = "DELETE FROM `user` WHERE id = ?";
        try{
            conn = new ConnectDb().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.executeUpdate();
        }catch(Exception e){
            
        }
    }
}
