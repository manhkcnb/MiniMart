/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc mạnh nguyễn
 */
public class DBConnector {
//    private  String hostname ="localhost"; 
//    private  String dbName ="mini-mart";
//    private  String username="root";
//    private  String password="";
    public static void main(String args[]){
         
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini-mart","root","")) {
            System.out.println("ketnoithnh cong");
            System.out.print(conn.getCatalog());
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
