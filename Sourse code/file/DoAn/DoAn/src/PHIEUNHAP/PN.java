/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PHIEUNHAP;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class PN {
    String MaPhieuNhap, MaSach, MaNCC, MaNV;
    Date NgayNhap;
    Float TongTienPN;
    PN(){
    }

    public PN(String MaPhieuNhap, String MaSach, String MaNCC, String MaNV, Date NgayNhap, Float TongTienPN) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSach = MaSach;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.TongTienPN = TongTienPN;
    }

    public PN(String MaSach, String MaNCC, String MaNV, Date NgayNhap, Float TongTienPN) {
        this.MaSach = MaSach;
        this.MaNCC = MaNCC;
        this.MaNV = MaNV;
        this.NgayNhap = NgayNhap;
        this.TongTienPN = TongTienPN;
    }

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public Float getTongTienPN() {
        return TongTienPN;
    }

    public void setTongTienPN(Float TongTienPN) {
        this.TongTienPN = TongTienPN;
    }
    
}
