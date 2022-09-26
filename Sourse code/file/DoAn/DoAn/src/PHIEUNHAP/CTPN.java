/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PHIEUNHAP;

/**
 *
 * @author hoang
 */
public class CTPN {
    String MaPhieuNhap, MaSach;
    int SoLuong;
    Float GiaNhap, ThanhTien;
    CTPN(){
        
    }
    public CTPN(String MaPhieuNhap, String MaSach, int SoLuong, Float GiaNhap, Float ThanhTien) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
    }

    public CTPN(String MaSach, int SoLuong, Float GiaNhap, Float ThanhTien) {
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
