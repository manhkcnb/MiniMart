/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TT
 */
public class Product {
    private int id;
    private String productName;
    private String productImg;
    private int price;
    private String description_1, description_2, description_3;
    private String origin;
    private int category_id;

    public Product(int id, String productName, String productImg, int price, String description_1, String description_2, String description_3, String origin, int category_id) {
        this.id = id;
        this.productName = productName;
        this.productImg = productImg;
        this.price = price;
        this.description_1 = description_1;
        this.description_2 = description_2;
        this.description_3 = description_3;
        this.origin = origin;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription_1() {
        return description_1;
    }

    public void setDescription_1(String description_1) {
        this.description_1 = description_1;
    }

    public String getDescription_2() {
        return description_2;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public String getDescription_3() {
        return description_3;
    }

    public void setDescription_3(String description_3) {
        this.description_3 = description_3;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    
    
}
