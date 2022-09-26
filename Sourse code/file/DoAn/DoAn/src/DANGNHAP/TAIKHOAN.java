/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DANGNHAP;

public class TAIKHOAN {
    String MaTK, TenTK, MatKhauTK, LoaiTK, MaNV;
    public TAIKHOAN(){
    }

    public TAIKHOAN(String MaTK, String TenTK, String MatKhauTK, String LoaiTK, String MaNV) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.MatKhauTK = MatKhauTK;
        this.LoaiTK = LoaiTK;
        this.MaNV = MaNV;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhauTK() {
        return MatKhauTK;
    }

    public void setMatKhauTK(String MatKhauTK) {
        this.MatKhauTK = MatKhauTK;
    }

    public String getLoaiTK() {
        return LoaiTK;
    }

    public void setLoaiTK(String LoaiTK) {
        this.LoaiTK = LoaiTK;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    
}
