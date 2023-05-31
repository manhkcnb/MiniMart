/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;
import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author TT
 */
public class ConnectDb {
    private final String url = "jdbc:mysql://localhost:3306/minimart";
    private final String user = "root";
    private final String password = "";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection() throws Exception{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(url, user, password);
    }
    public static void main(String[] args) {
        try {
            System.out.println("Database connection successful!");
            System.out.println(new ConnectDb().getConnection().getCatalog());
        } catch (Exception e) {
        }
    }
}