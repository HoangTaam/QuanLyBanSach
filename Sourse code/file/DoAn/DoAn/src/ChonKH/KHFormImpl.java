/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonKH;

import JDBC.connect;
import doan.KhachHang;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KHFormImpl implements KHDAO{
    @Override
    public List<KhachHang> getList() {
        try {
            Connection cons = connect.getJDBCConnection();
            String sql = "SELECT * FROM KHACHHANG";
            List<KhachHang> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSDT(rs.getString("SDT"));
                kh.setEmail(rs.getString("Email"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setDchi(rs.getString("DChi"));
                kh.setMaKH(rs.getString("MaKH"));
                kh.setLoaiKH(rs.getString("LoaiKH"));
                kh.setNgSinh(rs.getDate("NgSinh"));
                kh.setCMND(rs.getString("CMND"));
                list.add(kh);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } 
        catch (SQLException ex){
            ex.printStackTrace();
        }
    return null;
    }
    public static void main(String[] arg){
        KHDAO khdao = new KHFormImpl();
        System.out.println(khdao.getList());
    }
}
