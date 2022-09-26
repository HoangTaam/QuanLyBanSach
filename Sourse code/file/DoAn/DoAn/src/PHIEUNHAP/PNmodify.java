/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PHIEUNHAP;

/**
 *
 * @author hoang
 */
import doan.JDBCConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
public class PNmodify {
    public static PN find(String MaPN) throws Exception {
        String SQL = "select * from PHIEUNHAP where MaPhieuNhap = ?";
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaPN);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           PN pn = new PN();
            pn.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
            pn.setNgayNhap(rs.getDate("NgayNhap"));
            pn.setTongTienPN(rs.getFloat("TongTienPN"));
            pn.setMaNCC(rs.getString("MaNCC"));
            pn.setMaNV(rs.getString("MaNV"));
            return pn;
       }
       return null;
        }
    }
    public static boolean DeletePN(String MaPN) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Xoa_PN(?)}";
       try(
           CallableStatement cs = connection.prepareCall(sql); 
        ){
           cs.setString(1, MaPN);
           return cs.executeUpdate()>0;
       }
    }
    
    public static boolean InsertPN(PN pn) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO PHIEUNHAP(MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES(?,?,?,?)";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, pn.getMaPhieuNhap());
           ps.setDate(2, (Date) pn.getNgayNhap());
           ps.setString(3, pn.getMaNCC());
           ps.setString(4, pn.getMaNV());
           return ps.executeUpdate() >0;
       }
    }
    
    public static boolean UpdatePN(PN pn) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "UPDATE PHIEUNHAP SET NgayNhap = ?, MaNCC = ?, MaNV = ? WHERE MAPHIEUNHAP = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(4, pn.getMaPhieuNhap());
           ps.setDate(1, (Date) pn.getNgayNhap());
           ps.setString(2, pn.getMaNCC());
           ps.setString(3,pn.getMaNV());
           return ps.executeUpdate() >0;
       }
    }
    public static boolean Tinh_TongPN(String MaPN) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Tinh_TongPN(?)}";
       try(
               CallableStatement cs = connection.prepareCall(sql);
        ){
           
           cs.setString(1, MaPN);
           return cs.execute();
       }
    }
}
