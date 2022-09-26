/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.util.Date;

public class KhachHang {
    String MaKH, TenKH, SDT, Email, GioiTinh, Dchi, LoaiKH, CMND;
    Date NgSinh;
    public KhachHang(){   
    }

    public KhachHang(String MaKH, String TenKH, String SDT, String Email, String GioiTinh, String Dchi, String LoaiKH, String CMND, Date NgSinh) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.Dchi = Dchi;
        this.LoaiKH = LoaiKH;
        this.CMND = CMND;
        this.NgSinh = NgSinh;
    }

    public KhachHang(String TenKH, String SDT, String Email, String Dchi, String GioiTinh, String LoaiKH, String CMND, Date NgSinh) {
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.Dchi = Dchi;
        this.LoaiKH = LoaiKH;
        this.CMND = CMND;
        this.NgSinh = NgSinh;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDchi() {
        return Dchi;
    }

    public void setDchi(String Dchi) {
        this.Dchi = Dchi;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(String LoaiKH) {
        this.LoaiKH = LoaiKH;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public Date getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(Date NgSinh) {
        this.NgSinh = NgSinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    } 
}
