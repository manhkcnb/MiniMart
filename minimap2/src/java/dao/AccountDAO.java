/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import entity.Account;
import java.io.IOException;
import java.util.List;




/**
 *
 * @author pc mạnh nguyễn
 */
public class AccountDAO {
    Connection conn = null;
    PreparedStatement ps;
    ResultSet rs = null;

    public AccountDAO() {
        this.ps = null;
        // Không cần phải làm gì ở đây
    }

    public List<Account> getListAccounts() throws SQLException, IOException {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mini-mart", "root", "");
            String query = "select * from user";
//            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (rs.next()) {
                // Tạo đối tượng Account từ kết quả truy vấn
                Account account = new Account(rs.getString("userName"), rs.getString("password"));
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Đóng các đối tượng ResultSet, PreparedStatement, và Connection
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
