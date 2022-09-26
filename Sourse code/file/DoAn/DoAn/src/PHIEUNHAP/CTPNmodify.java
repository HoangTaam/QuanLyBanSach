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
import java.sql.Connection;
import java.sql.*;
public class CTPNmodify {
    public static CTPN find(String MaPN) throws Exception {
        String SQL = "select * from CTPHIEUNHAP where MaPhieuNhap =?";
        
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaPN);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           CTPN ct = new CTPN();
            ct.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
            ct.setMaSach(rs.getString("MaSach"));
            ct.setSoLuong(rs.getInt("SoLuong"));
            ct.setGiaNhap(rs.getFloat("GiaNhap"));
            return ct;
       }
       return null;
        }
    }
    public static boolean DeleteCTPN(String MaPN, String MaSach) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Xoa_CTPN(?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, MaPN);
           cs.setString(2, MaSach);
           return cs.execute();
       }
    }
    public static boolean InsertCTPN(CTPN ct) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Them_CTPN(?,?,?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, ct.getMaPhieuNhap());
           cs.setString(2, ct.getMaSach());
           cs.setInt(3, ct.getSoLuong());
           cs.setFloat(4, ct.getGiaNhap());
           return cs.execute();
       }
    }
    
    public static boolean UpdateCTPN(CTPN ct) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Cap_Nhat_CTPN(?,?,?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, ct.getMaPhieuNhap());
           cs.setString(2, ct.getMaSach());
           cs.setInt(3, ct.getSoLuong());
           cs.setFloat(4, ct.getGiaNhap());
           return cs.execute();
       }
    }
}
