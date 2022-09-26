package KMForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;
import java.sql.Date;

public class tacvuKM {
    public boolean insert(KhuyenMai KM)  throws Exception {
        String SQL = "insert into KHUYENMAI(MaKM, SoPhanTramGiam, KMTuNgay, KMDenNgay, DieuKienKM ) values(?,?,?,?,?)";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, KM.getMaKM());
            ps.setString(2, KM.getSoPhanTramGiam());
            ps.setDate(3, (Date) KM.getKMTuNgay());
            ps.setDate(4, (Date) KM.getKMDenNgay());
            ps.setString(5, KM.getDieuKienKM());
            
            return ps.executeUpdate() >0;
        }        
    }
    
      public KhuyenMai find(String MaKM) throws Exception {
        String SQL = "select * from KHUYENMAI where MaKM =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaKM);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           KhuyenMai KM = new KhuyenMai();
            KM.setMaKM(rs.getString("MaKM"));
            KM.setSoPhanTramGiam(rs.getString("SoPhanTramGiam"));
            KM.setKMTuNgay(rs.getDate("KMTuNgay"));
            KM.setKMDenNgay(rs.getDate("KMDenNgay"));
            KM.setDieuKienKM(rs.getString("DieuKienKM"));
            
            return KM;
       }
       
       return null;
        }
    }
      
    public boolean update(KhuyenMai KM)  throws Exception {
        String SQL = "update KHUYENMAI set  SoPhanTramGiam = ?, KMTuNgay=?, KMDenNgay=? ,DieuKienKM=? where MaKM = ?";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            )
        {
               
            ps.setString(5, KM.getMaKM());
            ps.setString(1, KM.getSoPhanTramGiam());
            ps.setDate(2, (Date) KM.getKMTuNgay());
            ps.setDate(3, (Date) KM.getKMDenNgay());
            ps.setString(4, KM.getDieuKienKM());
            
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaKM) throws Exception {
        String SQL = "delete from KHUYENMAI where MaKM=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaKM);
       return ps.executeUpdate() >0;
        }
    }
}
