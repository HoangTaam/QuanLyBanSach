/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TLForm;

import java.sql.Connection;
import TLForm.TheLoai;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;

public class tacvuTL {
    public boolean insert(TheLoai TL)  throws Exception {
        String SQL = "insert into THELOAI(MaTL, TenTL, MoTaTL ) values(?,?,?)";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, TL.getMaTL());
            ps.setString(2, TL.getTenTL());
            ps.setString(3, TL.getMoTaTL());
            
            return ps.executeUpdate() >0;
        }        
    }
    
      public TheLoai find(String MaTL) throws Exception {
        String SQL = "select * from THELOAI where MaTL =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaTL);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           TheLoai TL = new TheLoai();
            TL.setMaTL(rs.getString("MaTL"));
            TL.setTenTL(rs.getString("TenTL"));
            TL.setMoTaTL(rs.getString("MoTaTL"));
            
            return TL;
       }
       
       return null;
        }
    }
      
    public boolean update(TheLoai TL)  throws Exception {
        String SQL = "update THELOAI set  TenTL = ?, MoTaTL=? where MaTL = ?";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            )
        {
            ps.setString(3, TL.getMaTL());
            ps.setString(1, TL.getTenTL());
            ps.setString(2, TL.getMoTaTL());
            
               
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaTL) throws Exception {
        String SQL = "delete from THELOAI where MaTL=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaTL);
       return ps.executeUpdate() >0;
        }
    }

}
