/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;

import java.util.Date;
public class HD {
    String MaHD, MaNV, MaKH, MaKM;
    Date NgayMuaSach;
    Float TongTienHD;
    
    HD(){
    }

    public HD(String MaHD, String MaNV, String MaKH, String MaKM, Date NgayMuaSach, Float TongTienHD) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
        this.NgayMuaSach = NgayMuaSach;
        this.TongTienHD = TongTienHD;
    }

    public HD(String MaNV, String MaKH, String MaKM, Date NgayMuaSach, Float TongTienHD) {
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
        this.NgayMuaSach = NgayMuaSach;
        this.TongTienHD = TongTienHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public Date getNgayMuaSach() {
        return NgayMuaSach;
    }

    public void setNgayMuaSach(Date NgayMuaSach) {
        this.NgayMuaSach = NgayMuaSach;
    }

    public Float getTongTienHD() {
        return TongTienHD;
    }

    public void setTongTienHD(Float TongTienHD) {
        this.TongTienHD = TongTienHD;
    }
    
}
