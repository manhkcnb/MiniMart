/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dao.CartDao;
import java.util.*;

/**
 *
 * @author TT
 */
public class Order {
    private int id;
    private int cart_id;
    private String receiver;
    private String address;
    private String phone;
    private String note;
    private String status;
    private List<CartItem> cartItem;
    
    private CartDao dao = new CartDao();

    public Order(int id, int cart_id, String receiver, String address, String phone, String status, String note) {
        this.id = id;
        this.cart_id = cart_id;
        this.receiver = receiver;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.note = note;
        this.cartItem = dao.getListCartItemByCart(cart_id);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
}
