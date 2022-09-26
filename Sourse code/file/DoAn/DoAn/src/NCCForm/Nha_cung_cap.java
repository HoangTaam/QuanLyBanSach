/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NCCForm;

import java.sql.Connection;
import NCCForm.NhaCungCap;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;
/**
 *
 * @author DO THI THANH AN
 */
public class Nha_cung_cap {
    public boolean insert(NhaCungCap NCC)  throws Exception {
        String SQL = "insert into NHACC(MaNCC, TenNCC, SDT, Email, DChi ) values(?,?,?,?,?)";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, NCC.getMaNCC());
            ps.setString(2, NCC.getTenNCC());
            ps.setString(3, NCC.getSDT());
            ps.setString(4, NCC.getEmail());
            ps.setString(5, NCC.getDChi());
            
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public NhaCungCap find(String MaNCC) throws Exception {
        String SQL = "select * from NHACC where MaNCC =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNCC);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           NhaCungCap NCC = new NhaCungCap();
            NCC.setMaNCC(rs.getString("MaNCC"));
            NCC.setTenNCC(rs.getString("TenNCC"));
            NCC.setSDT(rs.getString("SDT"));
            NCC.setEmail(rs.getString("Email"));
            NCC.setDChi(rs.getString("DChi"));
            
            return NCC;
       }
       
       return null;
        }
    }
      
    public boolean update(NhaCungCap NCC)  throws Exception {
        String SQL = "update NHACC set  TenNCC = ?, SDT = ?, EMAIL=?, DChi=? where MaNCC = ?";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            )
        {
            ps.setString(5, NCC.getMaNCC());
            ps.setString(1, NCC.getTenNCC());
            ps.setString(2, NCC.getSDT());
            ps.setString(3, NCC.getEmail());
            ps.setString(4, NCC.getDChi());
            
               
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaNCC) throws Exception {
        String SQL = "delete from NHACC where MaNCC=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNCC);
       return ps.executeUpdate() >0;
        }
    }
}
