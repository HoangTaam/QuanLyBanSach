/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TLForm;

/**
 *
 * @author DO THI THANH AN
 */
public class TheLoai {
     public String MaTL, TenTL, MoTaTL;

    public TheLoai() {
    }

    public TheLoai(String MaTL, String TenTL, String MoTaTL) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
        this.MoTaTL = MoTaTL;
    }

    public String getMaTL() {
        return MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public String getMoTaTL() {
        return MoTaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public void setMoTaTL(String MoTaTL) {
        this.MoTaTL = MoTaTL;
    }
     
     
    
    
}
