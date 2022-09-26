/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
public class khmodify {
    public static List<KhachHang> getAllKH(){
       List<KhachHang> khlist = new ArrayList<>();
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "SELECT * FROM KHACHHANG";
       try{
           Statement PS = connection.createStatement();
           ResultSet rs = PS.executeQuery(sql);
           while(rs.next()){
               KhachHang a = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH")
                       , rs.getString("SDT"), rs.getString("Email"), rs.getString("Dchi") 
                       ,rs.getString("LoaiKH"), rs.getString("CMND"), rs.getDate("NgSinh"));
               khlist.add(a);   
           }
       }
       catch(SQLException e){
           e.printStackTrace();
       }
       return khlist;
    }
    public static boolean InsertKH(KhachHang kh) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO KHACHHANG(MaKH, TenKH, SDT, Email, GioiTinh, DChi, LoaiKH, NgSinh, CMND) VALUES(?,?,?,?,?,?,?,?,?)";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, kh.getMaKH());
           ps.setString(2, kh.getTenKH());
           ps.setString(3,kh.getSDT());
           ps.setString(4,kh.getEmail());
           ps.setString(5, kh.getGioiTinh());
           ps.setString(6,kh.getDchi());
           ps.setString(7,kh.getLoaiKH());
           ps.setDate(8, (Date) kh.getNgSinh());
           ps.setString(9,kh.getCMND());
           return ps.executeUpdate() >0;
       }
    }
    
    public static boolean DeleteKH(String MaKH) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "DELETE FROM KHACHHANG WHERE MAKH = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, MaKH);
           return ps.executeUpdate() >0;
       }
    }
    public static boolean UpdateKH(KhachHang kh) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "UPDATE KHACHHANG SET TenKH = ?, SDT = ?, Email = ?, GioiTinh = ?, DChi = ?, LoaiKH = ?, NgSinh = ?, CMND = ? WHERE MaKH = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(9, kh.getMaKH());
           ps.setString(1, kh.getTenKH());
           ps.setString(2,kh.getSDT());
           ps.setString(3,kh.getEmail());
           ps.setString(4,kh.getGioiTinh());
           ps.setString(5,kh.getDchi());
           ps.setString(6,kh.getLoaiKH());
           ps.setDate(7, (Date) kh.getNgSinh());
           ps.setString(8,kh.getCMND());
           return ps.executeUpdate() >0;
       }
    }
    public static KhachHang find(String MaKH) throws Exception {
        String SQL = "select * from KHACHHANG where MaKH =?";
        
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaKH);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           KhachHang kh = new KhachHang();
            kh.setMaKH(rs.getString("MaKH"));
            kh.setTenKH(rs.getString("TenKH"));
            kh.setSDT(rs.getString("SDT"));
            kh.setEmail(rs.getString("Email"));
            kh.setGioiTinh(rs.getString("GioiTinh"));
            kh.setDchi(rs.getString("Dchi"));
            kh.setNgSinh(rs.getDate("NgSinh"));
            kh.setCMND(rs.getString("CMND"));
            kh.setLoaiKH(rs.getString("LoaiKH"));
            return kh;
       }
       
       return null;
        }
    }
}
