package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pc mạnh nguyễn
 */
public class NewClass {
    public static void main(String args[]){
         
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini-mart","root","")) {
            System.out.println("ketnoithnh cong");
            System.out.print(conn.getCatalog());
        } catch (SQLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
