/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChonSach;

import SachForm.*;
import java.util.Date;

/**
 *
 * @author DO THI THANH AN
 */
public class ClassSach {
    
    public String MaSach,TenSach,TenTG;
    public Date NamXB;
    public String SLTon,GiaBan;
    public String MaTL;
    public String TheLoai;

    public ClassSach() {
    }

    public ClassSach(String MaSach, String TenSach, String TenTG, Date NamXB, String SLTon, String GiaBan, String MaTL) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NamXB = NamXB;
        this.SLTon = SLTon;
        this.GiaBan = GiaBan;
        this.MaTL = MaTL;
    }

    public ClassSach(String MaSach, String TenSach, String TenTG, Date NamXB, String SLTon, String GiaBan, String MaTL, String TheLoai) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.NamXB = NamXB;
        this.SLTon = SLTon;
        this.GiaBan = GiaBan;
        this.MaTL = MaTL;
        this.TheLoai = TheLoai;
    }
    

    public String getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTenTG() {
        return TenTG;
    }

    public Date getNamXB() {
        return NamXB;
    }

    public String getSLTon() {
        return SLTon;
    }


    public String getGiaBan() {
        return GiaBan;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public void setNamXB(Date NamXB) {
        this.NamXB = NamXB;
    }

    public void setSLTon(String SLTon) {
        this.SLTon = SLTon;
    }
    
    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }
    
}
