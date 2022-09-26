/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;

import doan.JDBCConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
public class HDmodify {
    public static HD find(String MaHD) throws Exception {
        String SQL = "select * from HOADON where MaHD = ?";
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaHD);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           HD hd = new HD();
            hd.setMaHD(rs.getString("MaHD"));
            hd.setNgayMuaSach(rs.getDate("NgayMuaSach"));
            hd.setTongTienHD(rs.getFloat("TongTienHD"));
            hd.setMaNV(rs.getString("MaNV"));
            hd.setMaKH(rs.getString("MaKH"));
            hd.setMaKM(rs.getString("MaKM"));
            return hd;
       }
       return null;
        }
    }
    public static boolean DeleteHD(String MaHD) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Xoa_HD(?)}";
       try(
           CallableStatement cs = connection.prepareCall(sql); 
        ){
           cs.setString(1, MaHD);
           return cs.executeUpdate()>0;
       }
    }
    public static boolean InsertHD(HD hd) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO HOADON(MaHD, NgayMuaSach, MaNV, MaKH, MaKM) VALUES(?,?,?,?,?)";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, hd.getMaHD());
           ps.setDate(2, (Date) hd.getNgayMuaSach());
           ps.setString(3, hd.getMaNV());
           ps.setString(4,hd.getMaKH());
           ps.setString(5, hd.getMaKM());
           return ps.executeUpdate() >0;
       }
    }
    
    public static boolean UpdateHD(HD hd) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "UPDATE HOADON SET NgayMuaSach = ?, MaNV = ?, MaKH = ?, MaKM = ? WHERE MAHD = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(5, hd.getMaHD());
           ps.setDate(1, (Date) hd.getNgayMuaSach());
           ps.setString(2, hd.getMaNV());
           ps.setString(3,hd.getMaKH());
           ps.setString(4, hd.getMaKM());
           return ps.executeUpdate() >0;
       }
    }
    public static boolean Tinh_TongHD(String MaHD) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "{call Tinh_TongHD(?)}";
       try{
           CallableStatement cs = connection.prepareCall(sql);
           cs.setString(1, MaHD);
           return cs.execute();
       }
       catch(SQLException ex){
            ex.printStackTrace();
       }
        return false;
    }
}
