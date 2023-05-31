/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TT
 */
public class Category {
    private int id;
    private String categoryName;
    private String categoryImg;

    public Category(int id, String categoryName, String categoryImg) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryImg = categoryImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryImg() {
        return categoryImg;
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", categoryName=" + categoryName + ", categoryImg=" + categoryImg + '}';
    }
    
}
