/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DANGNHAP;

import doan.JDBCConnection;
import java.sql.Connection;
import java.sql.*;

public class TKmodify {
    public static TAIKHOAN Login(String tdn, String mk) throws Exception{
        String sql = "SELECT * FROM TAIKHOAN WHERE TenTK LIKE ? AND MatKhauTK LIKE ?";
       try(
         Connection connection = JDBCConnection.getJDBCConnection();
         PreparedStatement ps = (PreparedStatement)connection.prepareStatement(sql);      
        ){
           ps.setString(1, tdn);
           ps.setString(2, mk);
           ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TAIKHOAN tk = new TAIKHOAN();
                tk.setMaTK(rs.getString("MaTK"));
                tk.setTenTK(rs.getString("TenTK"));
                tk.setMatKhauTK(rs.getString("MatKhauTK"));
                tk.setLoaiTK(rs.getString("LoaiTK"));
                tk.setMaNV(rs.getString("MaNV"));
                return tk;
            }
            ps.close();
            connection.close();
       }
       catch(SQLException ex){
           ex.printStackTrace();
       }
       return null;
    }
    
    public static TAIKHOAN find(String MaTK) throws Exception {
        String SQL = "select * from TAIKHOAN where MaTK =?";
        
        try(
            Connection conn = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
        ){
        ps.setString(1, MaTK);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           TAIKHOAN tk = new TAIKHOAN();
            tk.setMaTK(rs.getString("MaTK"));
            tk.setTenTK(rs.getString("TenTK"));
            tk.setMatKhauTK(rs.getString("MatKhauTK"));
            tk.setLoaiTK(rs.getString("LoaiTK"));
            tk.setMaNV(rs.getString("MaNV"));
            return tk;
       }
       return null;
        }
    }
    public static boolean DeleteTK(String MaTK) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "DELETE FROM TAIKHOAN WHERE MATK = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, MaTK);
           return ps.executeUpdate() >0;
       }
    }
    public static boolean InsertTK(TAIKHOAN tk) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "INSERT INTO TAIKHOAN(MaTK, TenTK, MatKhauTK, LoaiTK, MaNV) VALUES(?,?,?,?,?)";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(1, tk.getMaTK());
           ps.setString(2, tk.getTenTK());
           ps.setString(3, tk.getMatKhauTK());
           ps.setString(4, tk.getLoaiTK());
           ps.setString(5, tk.getMaNV());
           return ps.executeUpdate() >0;
       }
    }
    
    public static boolean UpdateTK(TAIKHOAN tk) throws Exception{
       Connection connection = JDBCConnection.getJDBCConnection();
       String sql = "UPDATE TAIKHOAN SET TenTK = ?, MatKhauTK = ?, LoaiTK = ?, MaNV = ? WHERE MATK = ?";
       try(
           PreparedStatement ps = connection.prepareStatement(sql);
        ){
           ps.setString(5, tk.getMaTK());
           ps.setString(1, tk.getTenTK());
           ps.setString(2, tk.getMatKhauTK());
           ps.setString(3, tk.getLoaiTK());
           ps.setString(4, tk.getMaNV());
           return ps.executeUpdate() >0;
       }
    }
}
