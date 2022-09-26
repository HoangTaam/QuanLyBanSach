
package ChonKM;

import JDBC.connect;
import KMForm.KhuyenMai;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class KMDAO {
    KMDAO(){
        
    }
    public List<KhuyenMai> getList() {
        try {
            Connection cons = connect.getJDBCConnection();
            String sql = "SELECT * FROM KHUYENMAI";
            List<KhuyenMai> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString("MaKM"));
                km.setSoPhanTramGiam(rs.getString("SoPhanTramGiam"));
                km.setKMTuNgay(rs.getDate("KMTuNgay"));
                km.setKMDenNgay(rs.getDate("KMDenNgay"));
                km.setDieuKienKM(rs.getString("DieuKienKM"));
                list.add(km);
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
        KMDAO kmdao = new KMDAO();
        System.out.println(kmdao.getList());
    }
}
