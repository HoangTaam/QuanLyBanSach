package KMForm;




import java.util.Date;

public class KhuyenMai {
    public String MaKM,SoPhanTramGiam;
    public Date KMTuNgay,KMDenNgay;
    public String DieuKienKM;

    public KhuyenMai() {
    }

    public KhuyenMai(String MaKM, String SoPhanTramGiam, Date KMTuNgay, Date KMDenNgay, String DieuKienKM) {
        this.MaKM = MaKM;
        this.SoPhanTramGiam = SoPhanTramGiam;
        this.KMTuNgay = KMTuNgay;
        this.KMDenNgay = KMDenNgay;
        this.DieuKienKM = DieuKienKM;
    }

    public String getMaKM() {
        return MaKM;
    }

    public String getSoPhanTramGiam() {
        return SoPhanTramGiam;
    }

    public Date getKMTuNgay() {
        return KMTuNgay;
    }

    public Date getKMDenNgay() {
        return KMDenNgay;
    }

    public String getDieuKienKM() {
        return DieuKienKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public void setSoPhanTramGiam(String SoPhanTramGiam) {
        this.SoPhanTramGiam = SoPhanTramGiam;
    }

    public void setKMTuNgay(Date KMTuNgay) {
        this.KMTuNgay = KMTuNgay;
    }

    public void setKMDenNgay(Date KMDenNgay) {
        this.KMDenNgay = KMDenNgay;
    }

    public void setDieuKienKM(String DieuKienKM) {
        this.DieuKienKM = DieuKienKM;
    }

    

}
