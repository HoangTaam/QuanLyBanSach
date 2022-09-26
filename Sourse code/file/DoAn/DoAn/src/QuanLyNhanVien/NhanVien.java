/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyNhanVien;

import java.util.Date;

/**
 *
 * @author DO THI THANH AN
 */
public class NhanVien {

        public String MaNV,TenNV,SDT,Email,GioiTinh,DChi,ChucVu,Luong;
        public Date NGSinh,NGVL;

        public NhanVien() {
        }

    public NhanVien(String MaNV, String TenNV, String SDT, String Email, String GioiTinh, String DChi, String ChucVu, String Luong, Date NGSinh, Date NGVL) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.DChi = DChi;
        this.ChucVu = ChucVu;
        this.Luong = Luong;
        this.NGSinh = NGSinh;
        this.NGVL = NGVL;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getDChi() {
        return DChi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getLuong() {
        return Luong;
    }

    public Date getNGSinh() {
        return NGSinh;
    }

    public Date getNGVL() {
        return NGVL;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public void setLuong(String Luong) {
        this.Luong = Luong;
    }

    public void setNGSinh(Date NGSinh) {
        this.NGSinh = NGSinh;
    }

    public void setNGVL(Date NGVL) {
        this.NGVL = NGVL;
    }
        
        

        
        
    
}
