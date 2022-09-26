/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;

import doan.JDBCConnection;
import java.sql.Connection;
import java.sql.*;
/**
 *
 * @author hoang
 */
public class CTHDmodify {
    public static chitiet find(String MaHD) throws Exception {
        String SQL = "select * from CTHD where MaHD =?";
        
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaHD);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           chitiet ct = new chitiet();
            ct.setMaHD(rs.getString("MaHD"));
            ct.setMaSach(rs.getString("MaSach"));
            ct.setSoLuong(rs.getInt("SoLuong"));
            return ct;
       }
       return null;
        }
    }
    public static boolean DeleteCTHD(String MaHD, String MaSach) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Xoa_CTHD(?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, MaHD);
           cs.setString(2, MaSach);
           return cs.execute();
       }
    }
    public static boolean InsertCTHD(String MaHD, String MaSach, int SL) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Them_CTHD(?,?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, MaHD);
           cs.setString(2, MaSach);
           cs.setInt(3, SL);
           return cs.execute();
       }
    }
    
    public static boolean InsertCTHD_LU(String MaHD, String MaSach, int SL) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Them_CTHD_LU(?,?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, MaHD);
           cs.setString(2, MaSach);
           cs.setInt(3, SL);
           return cs.execute();
       }
    }
    
    public static boolean UpdateCTHD(String MaHD, String MaSach, int SL) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Cap_Nhat_CTHD(?,?,?)}";
       try(
         CallableStatement cs = connection.prepareCall(sql);      
        ){
           cs.setString(1, MaHD);
           cs.setString(2, MaSach);
           cs.setInt(3, SL);
           return cs.execute();
       }
    }
}
