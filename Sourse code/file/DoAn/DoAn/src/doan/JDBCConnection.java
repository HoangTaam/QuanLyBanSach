/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

/**
 *
 * @author hoang
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection { 
    public static Connection getJDBCConnection(){
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "DoAn";
        String password = "doan";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                return DriverManager.getConnection(url,user, password);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
