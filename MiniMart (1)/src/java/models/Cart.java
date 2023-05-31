/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TT
 */
public class Cart {
    private int id;
    private int user_id;
    private int totalPrice;

    public Cart(int id, int user_id, int totalPrice) {
        this.id = id;
        this.user_id = user_id;
        this.totalPrice = totalPrice;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", user_id=" + user_id + ", totalPrice=" + totalPrice + '}';
    }
    
}
