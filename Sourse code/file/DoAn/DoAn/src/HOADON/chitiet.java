/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;

/**
 *
 * @author hoang
 */
public class chitiet {
    String MaHD, MaSach;
    Integer SoLuong;
    Float ThanhTien;
    chitiet(){
    }

    public chitiet(String MaHD, String MaSach, Integer SL) {
        this.MaHD = MaHD;
        this.MaSach = MaSach;
        this.SoLuong = SL;
    }

    public chitiet(String MaSach, Integer SL) {
        this.MaSach = MaSach;
        this.SoLuong = SL;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SL) {
        this.SoLuong = SL;
    }

    public Float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(Float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }    
}
