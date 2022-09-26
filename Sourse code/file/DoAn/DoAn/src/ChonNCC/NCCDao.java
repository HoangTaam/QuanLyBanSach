/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonNCC;

import JDBC.connect;
import NCCForm.NhaCungCap;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NCCDao {
    NCCDao(){
    }
    
    public List<NhaCungCap> getList() {
        try {
            Connection cons = connect.getJDBCConnection();
            String sql = "SELECT * FROM NHACC";
            List<NhaCungCap> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setDChi(rs.getString("DChi"));
                list.add(ncc);
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
        NCCDao nccdao = new NCCDao();
        System.out.println(nccdao.getList());
    }
}
