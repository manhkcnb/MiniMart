/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dao.ProductDao;

/**
 *
 * @author TT
 */
public class CartItem {
   private int id;
   private int product_id;
   private int count;
   private int cart_id;
   private Product product;
   
   private ProductDao dao = new ProductDao();

   public CartItem(int id, int product_id, int count, int cart_id) {
       this.id = id;
       this.product_id = product_id;
       this.count = count;
       this.cart_id = cart_id;
       this.product = dao.getProductById(product_id);
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItem{" + "id=" + id + ", product_id=" + product_id + ", count=" + count + ", cart_id=" + cart_id + ", product=" + product + ", dao=" + dao + '}';
    }
   
    
}
