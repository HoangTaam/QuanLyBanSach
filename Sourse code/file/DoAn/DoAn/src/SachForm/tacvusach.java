/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SachForm;

import java.sql.Connection;
import SachForm.ClassSach;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;
import java.sql.Date;

public class tacvusach {
    public boolean insert(ClassSach S)  throws Exception {
        String SQL = "insert into SACH(MaSach, TenSach, TenTG, NamXB, SLTon, GiaBan, MaTL ) values(?,?,?,?,?,?,?)";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, S.getMaSach());
            ps.setString(2, S.getTenSach());
            ps.setString(3, S.getTenTG());
            ps.setDate(4, (Date) S.getNamXB());
            ps.setString(5, S.getSLTon());
            ps.setString(6, S.getGiaBan());
            ps.setString(7, S.getMaTL());
            
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public ClassSach find(String MaSach) throws Exception {
        String SQL = "select * from SACH where MaSach =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaSach);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           ClassSach S = new ClassSach();
            S.setMaSach(rs.getString("MaSach"));
            S.setTenSach(rs.getString("TenSach"));
            S.setTenTG(rs.getString("TenTG"));
            S.setNamXB(rs.getDate("NamXB"));
            S.setSLTon(rs.getString("SLTon"));
            S.setGiaBan(rs.getString("GiaBan"));
            S.setMaTL(rs.getString("MaTL"));
            
            return S;
       }
       
       return null;
        }
    }
      
    public boolean update(ClassSach S)  throws Exception {
        String SQL = "update SACH set  TenSach = ?, TenTG = ?, NamXB=?, SLTon=?, GiaBan=?, MaTL=? where MaSach = ?";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            )
        {
               
            ps.setString(7, S.getMaSach());
            ps.setString(1, S.getTenSach());
            ps.setString(2, S.getTenTG());
            ps.setDate(3, (Date) S.getNamXB());
            ps.setString(4, S.getSLTon());
            ps.setString(5, S.getGiaBan());
            ps.setString(6, S.getMaTL());
            
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaSach) throws Exception {
        String SQL = "delete from Sach where MaSach=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaSach);
       return ps.executeUpdate() >0;
        }
    }
}
