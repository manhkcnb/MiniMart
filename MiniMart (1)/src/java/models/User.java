/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dao.UserDao;

/**
 *
 * @author TT
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private int role_id;
    private Role role;

    private UserDao dao = new UserDao();
    public User(int id, String userName, String password, String phone, String email, int role_id) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role_id = role_id;
        this.role = dao.getRoleById(role_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    
    
    
}
