/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pc mạnh nguyễn
 */
public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        AccountDAO accountDAO =new AccountDAO();
        List<Account> list =accountDAO.getListAccounts();
        for (Account a : list) {
            System.out.println(a.getUsename()+a.getPassword());
            
        }
    }
    
}
