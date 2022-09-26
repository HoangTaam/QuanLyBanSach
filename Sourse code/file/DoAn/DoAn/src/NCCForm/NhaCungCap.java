/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NCCForm;

/**
 *
 * @author DO THI THANH AN
 */
public class NhaCungCap {
    
    public String MaNCC,TenNCC,SDT,Email,DChi;

    public NhaCungCap() {
    }

    public NhaCungCap(String MaNCC, String TenNCC, String SDT, String Email, String DChi) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.SDT = SDT;
        this.Email = Email;
        this.DChi = DChi;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    public String getDChi() {
        return DChi;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }
    
    
}
