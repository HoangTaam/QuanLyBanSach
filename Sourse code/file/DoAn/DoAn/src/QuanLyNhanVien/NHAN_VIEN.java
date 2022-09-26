/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import java.sql.Connection;
import java.sql.Date;
import QuanLyNhanVien.NhanVien;
import java.sql.PreparedStatement;
import JDBC.*;
import java.sql.ResultSet;
/**

/**
 *
 * @author DO THI THANH AN
 */
public class NHAN_VIEN {
    public boolean insert(NhanVien NV)  throws Exception {
        String SQL = "insert into NhanVien(MaNV, TenNV, SDT, Email,GioiTinh, DChi, ChucVu, NGSinh, NGVL, Luong ) values(?,?,?,?,?,?,?,?,?,?)";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            ){
            ps.setString(1, NV.getMaNV());
            ps.setString(2, NV.getTenNV());
            ps.setString(3, NV.getSDT());
            ps.setString(4, NV.getEmail());
            ps.setString(5, NV.getGioiTinh());
            ps.setString(6, NV.getDChi());
            ps.setString(7, NV.getChucVu());
            ps.setDate(8, (Date) NV.getNGSinh());
            ps.setDate(9, (Date) NV.getNGVL());
            ps.setString(10, NV.getLuong());
               
            return ps.executeUpdate() >0;
        }        
    }
    
      public NhanVien find(String MaNV) throws Exception {
        String SQL = "select * from NHANVIEN where MaNV =?";
        
        try(
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNV);
       ResultSet rs = ps.executeQuery();
       if(rs.next()){
           NhanVien NV = new NhanVien();
            NV.setMaNV(rs.getString("MaNV"));
            NV.setTenNV(rs.getString("TenNV"));
            NV.setSDT(rs.getString("SDT"));
            NV.setEmail(rs.getString("Email"));
            NV.setGioiTinh(rs.getString("GioiTinh"));
            NV.setDChi(rs.getString("DChi"));
            NV.setChucVu(rs.getString("ChucVu"));
            NV.setNGSinh(rs.getDate("NGSinh"));
            NV.setNGVL(rs.getDate("NGVL"));
            NV.setLuong(rs.getString("Luong"));
            return NV;
       }
       
       return null;
        }
    }
      
    public boolean update(NhanVien NV)  throws Exception {
        String SQL = "update NhanVien set  TenNV = ?, SDT = ?, EMAIL=?, GioiTinh=? ,DChi=?, ChucVu=?, NGSinh=?, NGVL=?, Luong=? where MaNV = ?";
        
        try(
             Connection conn = connect.getJDBCConnection();
             PreparedStatement ps = conn.prepareStatement(SQL);
        
            )
        {
            ps.setString(10, NV.getMaNV());
            ps.setString(1, NV.getTenNV());
            ps.setString(2, NV.getSDT());
            ps.setString(3, NV.getEmail());
            ps.setString(4, NV.getGioiTinh());
            ps.setString(5, NV.getDChi());
            ps.setString(6, NV.getChucVu());
            ps.setDate(7, (Date) NV.getNGSinh());
            ps.setDate(8, (Date) NV.getNGVL());
            ps.setString(9, NV.getLuong());
               
            return ps.executeUpdate() >0;
        }        
    }
    
    public boolean delete(String MaNV) throws Exception {
        String SQL = "delete from NHANVIEN where MaNV=?";
    try(   
        Connection conn = connect.getJDBCConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ){
       ps.setString(1, MaNV);
       return ps.executeUpdate() >0;
        }
    }
}

