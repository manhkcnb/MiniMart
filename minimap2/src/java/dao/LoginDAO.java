/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;
import com.sun.jdi.connect.spi.Connection;
import context.DBContext;
import entity.Account;

/**
 *
 * @author pc mạnh nguyễn
 */
public class LoginDAO {
    Connection conn =null;
    PreparableStatement ps=null;// nems caau leenh tu netbeen sang sql
    Resultset rs =null; // nhaanj ket qua tra ve
    public Account checkLogin(String user ,String pass){
        try {
            String query ="select *from account where username=? and password =?";
            conn=new DBContext().getConnection();
            
        } catch (Exception e) {
        }
        return null;
    }
    

}
