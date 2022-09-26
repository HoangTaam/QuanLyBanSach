/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonSach;

import JDBC.connect;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SachDao {
    SachDao(){
        
    }
    public List<ClassSach> getList() {
        try {
            Connection cons = connect.getJDBCConnection();
            String sql = "SELECT * FROM SACH s, THELOAI t WHERE s.MaTL = t.MaTL";
            List<ClassSach> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ClassSach s = new ClassSach();
                s.setMaSach(rs.getString("MaSach"));
                s.setTenSach(rs.getString("TenSach"));
                s.setTenTG(rs.getString("TenTG"));
                s.setNamXB(rs.getDate("NamXB"));  
                s.setSLTon(rs.getString("SLTon"));
                s.setGiaBan(rs.getString("GiaBan"));
                s.setTheLoai(rs.getString("TenTL"));
                list.add(s);
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
}
