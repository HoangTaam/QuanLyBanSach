 CREATE TABLE KHACHHANG(
    MAKH VARCHAR2(10) NOT NULL PRIMARY KEY,
    TENKH VARCHAR2(50),
    SDT VARCHAR(12),
    Email VARCHAR2(50),
    GioiTinh VARCHAR2(5),
    DChi VARCHAR2(100),
    LoaiKH VARCHAR2(15),
    NGSinh DATE,
    CMND VARCHAR2(12)
)

CREATE TABLE NHANVIEN (
    MANV VARCHAR2(10) NOT NULL PRIMARY KEY,
    TenNV VARCHAR2(50),
    SDT VARCHAR2(12),
    Email VARCHAR2(50),
    GioiTinh VARCHAR2(5),
    DChi VARCHAR2(100),
    ChucVu VARCHAR2(15),
    NGSinh DATE,
    NGVL DATE,
    Luong NUMBER
)

CREATE TABLE TAIKHOAN(
    MaTK VARCHAR2(10) NOT NULL PRIMARY KEY,
    TenTK VARCHAR2(100),
    MatKhauTK VARCHAR2(100),
    LoaiTK VARCHAR2(20),
    MaNV VARCHAR2(10) references NHANVIEN(MaNV)
)
CREATE TABLE THELOAI(
    MaTL VARCHAR2(10) NOT NULL PRIMARY KEY,
    TenTL VARCHAR2(50),
    MoTaTL VARCHAR2(200)
)
CREATE TABLE SACH(
    MaSach VARCHAR2(10) NOT NULL PRIMARY KEY,
    TenSach VARCHAR2(50),
    TenTG VARCHAR2(50),
    NamXB DATE,
    SLTon number,
    GiaBan NUMBER,
    MaTL VARCHAR2(10)references THELOAI(MaTL)
)


CREATE TABLE KHUYENMAI(
    MaKM VARCHAR2(10)NOT NULL PRIMARY KEY,
    SoPhanTramGiam NUMBER,
    KMTuNgay date,
    KMDenNgay date,
    DieuKienKM varchar2(100)
)

CREATE TABLE HOADON(
    MaHD VARCHAR2(10) NOT NULL PRIMARY  KEY,
    NgayMuaSach DATE, 
    TongTienHD NUMBER,
    MaNV VARCHAR2(50) references NHANVIEN(MaNV),
    MAKH VARCHAR2(20) references KHACHHANG(MAKH),
    MaKM VARCHAR2(10) references KHUYENMAI(MaKM)
)

CREATE TABLE NHACC(
    MaNCC VARCHAR2(10) NOT NULL PRIMARY KEY,
    TenNCC VARCHAR2(50),
    SDT VARCHAR2(12),
    Email VARCHAR2(50),
    DChi VARCHAR2(100)
)

CREATE TABLE PHIEUNHAP(
    MaPhieuNhap VARCHAR2(10) NOT NULL PRIMARY KEY,
    NgayNhap DATE,
    TongTienPN NUMBER,
    MaNCC VARCHAR2(10),
    MaNV VARCHAR2(10) references NHANVIEN(MaNV)
)

CREATE TABLE CTHD(
    MaHD VARCHAR2(10) references HOADON(MaHD),
    MaSach VARCHAR2(10) references SACH(MaSach),
    SoLuong NUMBER,
    ThanhTien NUMBER,
  ---  MaKM varchar2(10) references KHUYENMAI(MaKM)
)

CREATE TABLE CTPHIEUNHAP(
    MaPhieuNhap VARCHAR2(10) NOT NULL PRIMARY KEY,
    MaSach VARCHAR2(10) references SACH(MaSach) ,
    SoLuong NUMBER,
    GiaNhap NUMBER,
    ThanhTien NUMBER
)

CREATE TABLE BAOCAO(
    MaBC VARCHAR2(10) NOT NULL PRIMARY KEY,
    NGLapBC DATE,
    TuNgay Date,
    DenNgay Date,
    TongDoanhSo number,
    MaNV VARCHAR2(10) references NHANVIEN(MaNV)
)
-----Trigger---
-----1. kt TU?I----
CREATE OR REPLACE TRIGGER KTTuoi
BEFORE INSERT ON NHANVIEN
FOR EACH ROW
BEGIN
  IF ((:new.NGVL - :new.NGSinh ) <=18) then
    RAISE_APPLICATION_ERROR(-2000,'Nhan vien chua du 18 tuoi');
  ELSE
    DBMS_OUTPUT.PUT_LINE('GIAO TAC THANH CONG');
  END IF;
END;
--------2. Luong k gi?m---
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER trg_NV_LuongKGiam
BEFORE INSERT OR UPDATE ON NHANVIEN
FOR EACH ROW
DECLARE
BEGIN
  IF :NEW.Luong< :OLD.Luong
  THEN
  RAISE_APPLICATION_ERROR(-2000, 'LUONG KHONG GIAM');
    END IF;
END;

---3 ngay sinh cua nhan vien nho hon ngay vao lam---
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER Check_NgayVaoLam
BEFORE INSERT OR UPDATE 
ON NHANVIEN
FOR EACH ROW
BEGIN
    
    IF :new.NGSinh>=:new.NGVL then
        RAISE_APPLICATION_ERROR(-20000,'Ngay sinh phai nho hon ngay vao lam');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Giao tac thanh cong');
    END IF;
END;
-------4. kiem tra gia: gia ban phai lon hon gia nhap------
SET SERVEROUTPUT ON;
create or replace TRIGGER Check_Gia
BEFORE INSERT OR UPDATE
ON CTPHIEUNHAP
FOR EACH ROW
declare 
    checkg number;
BEGIN
 SELECT count(S.masach) into checkg
 FROM Sach S
  WHERE S.MaSach = :NEW.MaSach and :NEW.GiaNhap > S.GiaBan;
 IF checkg > 0 
 THEN
  RAISE_APPLICATION_ERROR(-2000, 'Gia nhap phai nho hon gia ban');
  ELSE
    DBMS_OUTPUT.PUT_LINE('DA THEM THANH CONG');
  END IF;
END;
----------5.tinh tien trong CTPHIEUNHAP------
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER TINHTIEN
BEFORE INSERT 
ON CTPHIEUNHAP
FOR EACH ROW
BEGIN

 :NEW.ThanhTien := :NEW.GIANHAP * :NEW.SOLUONG;
 
END;
--------6. Tinh tien trong CTHD----
SET SERVEROUTPUT ON;
DROP TRIGGER TTHoaDON;
CREATE OR REPLACE TRIGGER TT_CTHoaDon
BEFORE INSERT OR UPDATE
ON CTHD
FOR EACH ROW
DECLARE
v_MS NUMBER;
v_GiaBan NUMBER;
BEGIN
 SELECT GIABAN INTO v_GiaBan
 FROM SACH
 WHERE SACH.MASACH= :NEW.MASACH;
 IF (:NEW.MASACH IS NOT NULL)
 THEN
 :NEW.ThanhTien := v_GiaBan* :NEW.SOLUONG;
 END IF;
END;

--Them KH—
INSERT INTO KHACHHANG VALUES ('KH001','Nguy?n V?n A','0987654321','VanA@gmail.com','Nam' ,'Qu?n 1','Th??ng','01-01-2020','112342543');
INSERT INTO KHACHHANG VALUES ('KH002','Nguy?n V?n B','012342543','VanB@gmail.com','Nam','Qu?n 4','Thân thi?t','04-02-2019','112365443');
INSERT INTO KHACHHANG VALUES ('KH003','Tr?n V?n C','012347533','VanC@gmail.com','Nam','Qu?n 2','Th??ng','06-04-2020','112347533');
INSERT INTO KHACHHANG VALUES ('KH004','Nguy?n V?n D','054342543','VanD@gmail.com','Nam','Qu?n 6','Th??ng','04-04-2020','112347533');
INSERT INTO KHACHHANG VALUES ('KH005','Nguy?n V?n E','076442543','VanE@gmail.com','Nam','Qu?n 7','Thân thi?t','05-05-2019','354342543');
INSERT INTO KHACHHANG VALUES ('KH006','Lê Th? An','0987644321','ThiAn@gmail.com','N?','Qu?n 8','Th??ng','03-07-2020','176442543');
INSERT INTO KHACHHANG VALUES ('KH007','Nguy?n Th? Trân','0981234321','ThiTran@gmail.com','N?','Qu?n 3','Th??ng','07-05-2020','115422543');
INSERT INTO KHACHHANG VALUES ('KH008','?? Th? Lan','0876654321','ThiLan@gmail.com','N?','Qu?n 1','Th??ng','08-10-2020','118762543');
INSERT INTO KHACHHANG VALUES ('KH009','Nguy?n Thanh Hà','0990154321','ThanhHa@gmail.com','N?','Qu?n 8','Th??ng','13-06-2020','754342543');
INSERT INTO KHACHHANG VALUES ('KH010','Tr??ng Kim An','098632321','KimAn@gmail.com','N?','Qu?n 5','Thân thi?t','21-12-2018','743342543');
INSERT INTO KHACHHANG VALUES ('KH011','Nguy?n Th? Minh','0966624351', 'ThiMinh@gmail.com', 'N?' ,'Qu?n 5','Th??ng','01-01-1976','122342543');
INSERT INTO KHACHHANG VALUES ('KH012','?? V?n Tu?n', '098842543', 'VanTuan@gmail.com', 'Nam','Qu?n 4','Thân thi?t','04-02-1978','199965443');
INSERT INTO KHACHHANG VALUES ('KH013','Lê Thanh Ch??ng','099947533','ThanhChuong@gmail.com','Nam','Qu?n 2','Th??ng','06-04-2084','100347533');
INSERT INTO KHACHHANG VALUES ('KH014','Nguy?n Chí Thanh','051142543', 'ChiThanh@gmail.com', 'Nam','Qu?n 6','Th??ng','04-04-1999','187347533');
INSERT INTO KHACHHANG VALUES ('KH015','Tr?n Thanh Tâm','098442543','ThanhTam@gmail.com', 'Nam','Qu?n 7','Thân thi?t','05-05-2000','354342543');
INSERT INTO KHACHHANG VALUES ('KH016','Mai Th??ng Anh', '0955644321', 'ThuongAnh@gmail.com', 'N?', 'Qu?n 8','Th??ng','03-07-2000','166442543');
INSERT INTO KHACHHANG VALUES ('KH017','Nguy?n Th? Hoa','0881234321','ThiHoa@gmail.com', 'N?','Qu?n 3','Th??ng','07-05-1993','112222543');
INSERT INTO KHACHHANG VALUES ('KH018','Nguy?n Th? Hòa','0876832321', 'ThiHoa@gmail.com', 'N?','Qu?n 1','Th??ng','08-10-1986','118782543');
INSERT INTO KHACHHANG VALUES ('KH019','Lê M? Ngân', '0991154321', 'MyNgan@gmail.com', 'N?', 'Qu?n 8','Th??ng','13-06-1992','192342543');
INSERT INTO KHACHHANG VALUES ('KH020','?? Vân An','098332321','VanAn@gmail.com','N?','Qu?n 5','Thân thi?t','21-12-1995','192342543');
COMMIT;

COMMIT;

--Them NV—
INSERT INTO NHANVIEN VALUES ('NV001','Nguy?n Thanh An','0987111321','ThanhAn@gmail.com','N?','Qu?n 3','Qu?n Lý','01-04-1995','01-04-2018','15000000');
INSERT INTO NHANVIEN VALUES ('NV002','Lê Kim Thành','0987222322','KimThanh@gmail.com','N?','Qu?n 4','Bán Hàng','02-05-1994','01-05-19','9000000');
INSERT INTO NHANVIEN VALUES ('NV003','Lê Ng?c Di?m','0987333323','NgocDiem@gmail.com','N?','Qu?n 5','Bán Hàng','03-07-1995','01-07-2020','7000000');
INSERT INTO NHANVIEN VALUES ('NV004','Lê Kim Trúc','0987444324','KimTruc@gmail.com','N?','Qu?n 7','Bán Hàng','06-10-1996','01-05-2020','8000000');
INSERT INTO NHANVIEN VALUES ('NV005','Tr??ng H?u Duy ','0987555325','HuuDuy@gmail.com','Nam','Qu?n 3','Nh?p Hàng','09-09-1993','07-01-2020','7000000');
INSERT INTO NHANVIEN VALUES ('NV006','Nguy?n Chí Công','0987666326','ChiCong@gmail.com','Nam','Qu?n 2','Nh?p Hàng','11-05-1998','11-07-2019','8500000');
INSERT INTO NHANVIEN VALUES ('NV007','Nguy?n Duy Khánh','0987777327','DuyKhanh@gmail.com','Nam','Qu?n 3','Nh?p Hàng','23-01-2001','10-06-2019','8500000');
INSERT INTO NHANVIEN VALUES ('NV008','Hoàng Trí Tâm','0987777327','TriTam@gmail.com','Nam','Qu?n 9','Bán Hàng','15-05-2001','05-08-2019','9500000');
INSERT INTO NHANVIEN VALUES ('NV009','Ph?m Minh Th?ng','0987552325','MinhThang@gmail.com','Nam','Qu?n 1','Nh?p Hàng','10-03-1993','02-01-2020','8000000');
COMMIT;

--Them TaiKhoan—
INSERT INTO TAIKHOAN VALUES ('TK001','ThanhAn','ThanhAn001','Qu?n Lý','NV001');
INSERT INTO TAIKHOAN VALUES ('TK002','KimThanh','KimThanh002','Bán Hàng','NV002');
INSERT INTO TAIKHOAN VALUES ('TK003','NgocDiem','NgocDiem003','Bán Hàng','NV003');
INSERT INTO TAIKHOAN VALUES ('TK004','KimTruc','KimTruc004','Bán Hàng','NV004');
INSERT INTO TAIKHOAN VALUES ('TK005','HuuDuy','HuuDuy005','Nh?p Hàng','NV005');
INSERT INTO TAIKHOAN VALUES ('TK006','ChiCong','ChiCong006','Nh?p Hàng','NV006');
INSERT INTO TAIKHOAN VALUES ('TK007','DuyKhanh','DuyKhanh007','Nh?p Hàng','NV007');
INSERT INTO TAIKHOAN VALUES ('TK008','TriTam','TriTam008','Bán Hàng','NV008');
INSERT INTO TAIKHOAN VALUES ('TK009','MinhThang','MinhThang009','Nh?p Hàng','NV009');
COMMIT;

--Them The loai--
INSERT INTO THELOAI VALUES('TL001','Chính Tr?','');
INSERT INTO THELOAI VALUES('TL002','Pháp Lu?t','');
INSERT INTO THELOAI VALUES('TL003','Kinh T?','');
INSERT INTO THELOAI VALUES('TL004','Ti?ng Anh','');
INSERT INTO THELOAI VALUES('TL005','V?n H?c','');
INSERT INTO THELOAI VALUES('TL006','Ti?u Thuy?t','');
INSERT INTO THELOAI VALUES('TL007','Truy?n','');
INSERT INTO THELOAI VALUES('TL008','Sách giáo khoa','');
INSERT INTO THELOAI VALUES('TL009','Sách thi?u nhi','');
INSERT INTO THELOAI VALUES('TL010','Tâm lý','');

COMMIT;

--Them Sach --
INSERT INTO SACH VALUES('S001','C?ng Hòa', 'Platon', '01-09-2019', 100, 70000,'TL001');
INSERT INTO SACH VALUES('S002','Tuyên ngôn c?a ??ng C?ng S?n', 'Karl Marx', '11-12-2018', 150, 100000,'TL001');
INSERT INTO SACH VALUES('S003','Tài ba c?a lu?t s?', 'Nguy?n Ng?c Bích', '06-10-2017', 90, 90000,'TL002');
INSERT INTO SACH VALUES('S004','Kinh ?i?n kh?i nghi?p', 'Bill Aulet', '04-05-2018', 70, 130000,'TL003');
INSERT INTO SACH VALUES('S005','Nhà ??u t? thông minh', 'Benjamin Graham', '05-10-2018', 100, 135000,'TL003');
INSERT INTO SACH VALUES('S006','Easy English Conversation', 'Nguy?n Ng?c Hoa', '04-10-2018', 70, 160000,'TL004');
INSERT INTO SACH VALUES('S007','Luy?n ?? ETS 2020', 'Nguy?n Ng?c Hoa', '10-03-2020', 70, 130000,'TL004');
INSERT INTO SACH VALUES('S008','Chí phèo', 'Nam Cao', '14-10-2019', 100, 100000,'TL005');
INSERT INTO SACH VALUES('S009','T?t ?èn', 'Ngô T?t T?', '15-11-2018', 90, 80000,'TL005');
INSERT INTO SACH VALUES('S010','V? nh?t', 'Kim Lân', '12-12-2019', 100, 90000,'TL005');
INSERT INTO SACH VALUES('S011','Th?t t?ch không m?a', 'Lâu v? tình', '10-05-2019', 80, 85000,'TL006');
INSERT INTO SACH VALUES('S012','Cô gái n?m ?y chúng ta cùng theo ?u?i', 'C?u B? ?ao', '11-06-2019', 85, 90000,'TL006');
INSERT INTO SACH VALUES('S013','Once piece t?p 100', 'Oda Eiichiro', '10-10-2019', 100, 50000,'TL007');
INSERT INTO SACH VALUES('S014','Doraemon t?p 80', 'Fujiko Fujio', '18-05-2019', 150,60000,'TL007');
INSERT INTO SACH VALUES('S015','H? qu?n tr? c? s? d? li?u', 'Nhi?u tác gi?', '10-7-2019', 50, 28000,'TL007');
INSERT INTO SACH VALUES('S016','Phân tích thi?t k? h? th?ng thông tin', 'Nhi?u tác gi?', '10-7-2019', 50, 62000,'TL007');
INSERT INTO SACH VALUES('S017','??u t? tài chính', 'Nhi?u tác gi?', '10-7-2019', 50, 500000,'TL003');
INSERT INTO SACH VALUES('S018','Ti?n chùa', 'Louis Brandeis', '16-3-2019', 50, 100000,'TL003');
INSERT INTO SACH VALUES('S019','Kh?i nghi?p v?i 100$', 'Chris Guillebeau', '26-5-2018', 40, 89000,'TL003');
INSERT INTO SACH VALUES('S020','C?m Nang C?u Trúc Ti?ng Anh', 'Trang Anh', '10-4-2019', 50,98000,'TL004');
INSERT INTO SACH VALUES('S021','Little Stories - To Get More Knowledge', 'Claire Luong', '5-4-2019', 30, 68000,'TL004');
INSERT INTO SACH VALUES('S022','Chuyên ?? Ng? Pháp Ti?ng Anh', 'Trang Anh', '16-11-2019', 40, 110000,'TL004');
INSERT INTO SACH VALUES('S023','T? H?c 2000 T? V?ng Ti?ng Anh', 'The Windy', '6-2-2019', 40, 72000,'TL004');
INSERT INTO SACH VALUES('S024','Ti?ng Anh GenZ', 'English not boring', '17-8-2021', 50, 50000, 'TL004');
INSERT INTO SACH VALUES('S025','S? ??', 'V? Tr?ng Ph?ng', '1-8-2019', 30, 920000,'TL005');
INSERT INTO SACH VALUES('S026','Giông t?', 'V? Tr?ng Ph?ng', '22-3-2019', 40, 89000,'TL005');
INSERT INTO SACH VALUES('S027','Lão h?c', 'Nam Cao', '6-2-2019', 30, 88000,'TL005');
INSERT INTO SACH VALUES('S028','L?u chõng', 'Ngô T?t T?', '14-9-2019', 40,86000,'TL005');
INSERT INTO SACH VALUES('S029','Gió ??u mùa', 'Th?ch Lam', '6-9-2019', 30,101000,'TL005');
INSERT INTO SACH VALUES('S030','Tam qu?c di?n ngh?a', 'La Quán Trung', '6-6-2018', 30,140000,'TL006');
INSERT INTO SACH VALUES('S031','Anh có thích n??c M? không?', 'Tân Di ?', '16-2-2018', 40, 145000,'TL006');
INSERT INTO SACH VALUES('S032','Hóa ra anh ? ?ây', 'Tân Di ?', '11-3-2019', 30, 135000,'TL006');
INSERT INTO SACH VALUES('S033','Hoa t? d?n', '???ng Th?t Công T?', '16-7-2017', 50,155000,'TL006');
INSERT INTO SACH VALUES('S034','C?m tú duyên', '???ng Th?t Công T?', '2-4-2017', 40, 150000,'TL006');
INSERT INTO SACH VALUES('S035','Doraemon t?p 81', 'Fujiko Fujio', '4-10-2019', 50, 60000,'TL009');
INSERT INTO SACH VALUES('S036','Doraemon t?p 82', 'Fujiko Fujio', '4-6-2019', 50, 60000,'TL009');
INSERT INTO SACH VALUES('S037','Conan t?p 1', 'Aoyama G?sh?.', '22-12-2019', 50,60000,'TL009');
INSERT INTO SACH VALUES('S038','Conan t?p 2', 'Aoyama G?sh?.', '25-7-2019', 50, 60000,'TL009');
INSERT INTO SACH VALUES('S039','Conan t?p 3', 'Aoyama G?sh?.', '6-10-2019', 50, 60000,'TL009');
INSERT INTO SACH VALUES('S040','Xác su?t th?ng kê', 'Nhi?u tác gi?', '16-11-2019', 50, 60000,'TL007');
INSERT INTO SACH VALUES('S041','L?p trình h??ng ??i t??ng', 'Nhi?u tác gi?', '1-12-2019', 40, 50000,'TL007');
INSERT INTO SACH VALUES('S042','C?u trúc d? li?u và gi?i thu?t', 'Nhi?u tác gi?', '28-6-2019',30, 65000,'TL007');
INSERT INTO SACH VALUES('S043','Nh?p môn m?ng máy tính', 'Nhi?u tác gi?', '9-4-2019', 40, 500000,'TL007');
INSERT INTO SACH VALUES('S044','Nh?p môn l?p trình', 'Nhi?u tác gi?', '10-12-2019', 50, 55000,'TL007');
COMMIT;

--Them KM--
INSERT INTO KHUYENMAI VALUES('KM001',5,'01-04-2020','30-04-2020',1000000);
INSERT INTO KHUYENMAI VALUES('KM002',7,'01-10-2019','31-10-2019',2000000);
INSERT INTO KHUYENMAI VALUES('KM003',10,'01-05-2021','15-05-2021',3000000);
INSERT INTO KHUYENMAI VALUES('KM004',20,'23-12-2020','31-12-2020',2000000);
INSERT INTO KHUYENMAI VALUES('KM005',10,'01-01-2021','10-01-2021',3000000);
INSERT INTO KHUYENMAI VALUES('KM006',15,'10-04-2021','15-04-2021',3000000);
INSERT INTO KHUYENMAI VALUES('KM007',10,'22-12-2019','31-12-2019',2000000);
INSERT INTO KHUYENMAI VALUES('KM008',10,'01-05-2019','15-05-2019',500000);
INSERT INTO KHUYENMAI VALUES('KM009',5,'02-07-2019','07-07-2019',1000000);
INSERT INTO KHUYENMAI VALUES('KM010',8,'01-09-2019','10-09-2019',500000);
INSERT INTO KHUYENMAI VALUES('KM011',10,'01-09-2020','10-09-2020',2000000);
INSERT INTO KHUYENMAI VALUES('KM012',10,'01-05-2020','15-05-2020',500000);
INSERT INTO KHUYENMAI VALUES('KM013',20,'01-06-2020','05-06-2020',500000);
INSERT INTO KHUYENMAI VALUES('KM014',10,'01-03-2020','05-03-2020',1000000);
INSERT INTO KHUYENMAI VALUES('KM015',5,'01-11-2019','05-11-2019',500000);


--ThemHD---
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD001','12-04-2020','NV001','KH005','KM001');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD002','10-05-2019','NV004','KH002','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD003','20-05-2021','NV005','KH001','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD004','12-05-2021','NV002','KH003','KM003');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD005','10-09-2020','NV001','KH005','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD006','20-10-2019','NV005','KH002','KM002');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD007','2-11-2019','NV001','KH006','KM015');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD008','23-10-2019','NV002','KH007','KM003');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD009','25-10-2019','NV003','KH008','KM002');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD010','27-10-2019','NV004','KH009','KM002');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD011','27-10-2019','NV004','KH010','KM002');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD012','29-10-2019','NV005','KH011','KM002');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD013','3-11-2019','NV008','KH012','KM015');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD014','5-11-2019','NV002','KH013','KM015');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD015','7-11-2020','NV009','KH014','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD016','23-11-2019','NV002','KH015','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD017','25-11-2020','NV003','KH016','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD018','23-12-2019','NV002','KH017','KM007');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD019','25-12-2020','NV005','KH018','KM007');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD020','27-12-2019','NV006','KH019','KM007');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD021','3-1-2020','NV009','KH020','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD022','3-1-2020','NV009','KH007','');
INSERT INTO HOADON(MaHD, NGAYMUASACH, MANV, MAKH, MAKM) VALUES('HD023','5-1-2020','NV002','KH009','');


--ThemCTHD--
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)  VALUES('HD001','S001',10,'KM001');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD001','S002',5,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD002','S002',5,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD001','S003',20,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD002','S003',10,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD001','S004',50,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD003','S003',10,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD003','S001',15,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD003','S004',20,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM)   VALUES('HD002','S001',20,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong, MaKM) VALUES('HD005','S007',20,'');
INSERT INTO CTHD(MaHD, MaSach, SoLuong)VALUES('HD003','S007','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD003','S009','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD003','S022','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD004','S011','10');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD004','S013','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD004','S035','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD004','S021','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD004','S042','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD005','S016','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD005','S023','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD005','S024','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD005','S032','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD006','S018','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD006','S041','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD006','S011','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD007','S025','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD007','S037','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD008','S022','4');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD008','S042','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD009','S012','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S022','4');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S037','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S018','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD011','S015','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD012','S041','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD013','S038','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD013','S011','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD014','S002','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD014','S010','7');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD015','S027','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD015','S023','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD016','S019','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD016','S020','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD017','S040','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD018','S032','10');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD018','S016','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD019','S008','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD019','S011','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD020','S005','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD021','S003','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD021','S029','3');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD022','S025','1');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD022','S013','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD023','S017','5');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD023','S004','2');
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD023','S037','1');
---
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD005','S002',2); --NV001--

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD008','S004',20); --NV003--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD008','S001',10);

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD009','S006',20); --NV004--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD009','S002',10);

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S010',20); --NV005--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S011',10);
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD010','S003',30);

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD011','S008',20); --NV006--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD011','S007',10);
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD011','S004',30);

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD012','S012',10); --NV007--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD012','S013',10);
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD012','S014',50);

INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD013','S004',20); --NV008--
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD013','S005',20);
INSERT INTO CTHD(MaHD, MaSach, SoLuong) VALUES('HD013','S009',20);
COMMIT;


-------

----
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN001','27/8/2019','CC001','NV001');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN002','27/9/2019','CC002','NV002');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN003','27/10/2019','C003','NV003');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN004','27/11/2019','CC001','NV001');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN005','27/12/2019','CC002','NV002');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN006','27/1/2020','CC004','NV003');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN007','27/2/2020','CC005','NV001');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN008','20/3/2020','CC006','NV002');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN009','22/5/2020','CC004','NV003');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN010','27/6/2020','CC008','NV001');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN011','27/7/2020','CC009','NV002');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN012','27/8/2020','CC010','NV003');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN013','27/9/2020','CC002','NV001');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN014','27/10/2020','CC008','NV002');
INSERT INTO PHIEUNHAP ( MaPhieuNhap, NgayNhap, MaNCC, MaNV) VALUES ('PN015','27/11/2020','CC005','NV001');


--------0---
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap)  VALUES('PN001', 'S001', '30', '70000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN001', 'S002', '20', '70000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN001', 'S003', '30', '60000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN002', 'S004', '50', '100000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN002', 'S005', '30', '100000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN003', 'S006', '20', '120000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN003', 'S007', '30', '130000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN004', 'S008', '30', '60000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN004', 'S009', '30', '50000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN005', 'S010', '30', '60000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN005', 'S011', '50', '50000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN006', 'S012', '30', '60000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN006', 'S022', '30', '60000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN006', 'S023', '50', '48000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN007', 'S013', '30', '30000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN007', 'S024', '30', '50000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN008', 'S014', '40', '35000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN008', 'S025', '50', '50000');
 
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN009', 'S015', '30', '77000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN009', 'S026', '45', '44000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN010', 'S016', '20', '30000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN010', 'S027', '50', '40000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN010', 'S028', '30', '46000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN011', 'S017', '30', '40000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN011', 'S029', '50', '55000');
INSERT INTO CTPHIEUNHAP ( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN012', 'S018', '50', '70000');
INSERT INTO CTPHIEUNHAP( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN013', 'S019', '30', '62000');
INSERT INTO CTPHIEUNHAP( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN014', 'S020', '50', '58000');
INSERT INTO CTPHIEUNHAP( MaPhieuNhap, MaSach, SoLuong, GiaNhap) VALUES ('PN015', 'S021', '60', '39000'); 
----------------------------
---1.	C?p nh?t chi ti?t hóa ??n:
create or replace PROCEDURE Cap_Nhat_CTHD(in_MaHD HOADON.MaHD%TYPE, in_MaSach SACH.MaSach%TYPE, in_SL CTHD.SOLUONG%TYPE)
AS
  v_ThanhTien number:= 0;
  v_SLTon number;
  v_GiaBan number;
  v_SLCo number;
  v_SLConLai number;
BEGIN
  --Lay tt thong tin sach--
  SELECT SLTon, GiaBan INTO v_SLTon,v_GiaBan
  FROM Sach
  WHERE MaSach = in_MaSach;
  --Lay SL dang co trong CTHD--
  SELECT SOLUONG into v_SLCo
  FROM CTHD
  WHERE MaHD = in_MaHD and MaSach = in_MaSach;
  --
  IF(in_SL <= v_SLTon) --Kiem tra so luong sach trong kho co du--
    Then
      v_SLConLai:=v_SLTon + v_SLCo - in_SL;
      v_ThanhTien:=in_SL*v_GiaBan;
    UPDATE SACH
    SET SLTON =v_SLConLai
    WHERE MaSach = in_MaSach;
    COMMIT;
    UPDATE CTHD
    SET SoLuong = in_SL, ThanhTien = v_ThanhTien
    WHERE MaHD = in_MaHD and MaSach = in_MaSach;
    COMMIT;
    ELSE RAISE_APPLICATION_ERROR(-20003,'S? l??ng sách trong kho không ??');
    END IF;
END;
----2.	C?p nh?t chi ti?t phi?u nh?p:
create or replace PROCEDURE Cap_Nhat_CTPN(in_MaPN PHIEUNHAP.MAPHIEUNHAP%TYPE, in_MaSach SACH.MaSach%TYPE,in_SL CTPHIEUNHAP.SOLUONG%TYPE, in_GiaNhap CTPHIEUNHAP.GIANHAP%TYPE)
AS
  v_MaPN varchar2(10);
  v_MaSach varchar2(10);
  v_SLTon number;
  v_SLMoi number;
  v_SL number; --So luong co trong CTPN--
  v_ThanhTien number;
BEGIN
  --Lay So Luong Co trong CTPN
  SELECT SOLUONG INTO v_SL
  FROM CTPHIEUNHAP
  WHERE MaPhieuNhap = in_MaPN and MaSach = in_MaSach;
  --
  v_SLMoi:= (v_SLTon - v_SL + in_SL);
  UPDATE SACH SET SLTON = v_SLMoi WHERE MaSach = in_MaSach;
  v_ThanhTien:=in_SL*in_GiaNhap;
  UPDATE CTPHIEUNHAP 
  SET SoLuong = in_SL, ThanhTien = v_ThanhTien, GiaNhap = in_GiaNhap
  WHERE MaPhieuNhap = in_MaPN and MaSach = in_MaSach;
  COMMIT;
END;
-----3.	Thêm CTHD:
create or replace PROCEDURE Them_CTHD(in_MaHD HOADON.MaHD%TYPE, in_MaSach SACH.MaSach%TYPE, in_SL CTHD.SOLUONG%TYPE)
AS
  v_ThanhTien number:= 0;
  v_MaHD varchar2(10);
  v_MaSach varchar2(10);
  v_SLTon number;
  v_GiaBan number;
  v_SLConLai number;
BEGIN
  --Lay MaHD--
  SELECT MaHD INTO v_MaHD
  FROM HOADON
  WHERE MaHD = in_MaHD;
  --Lay tt thong tin sach--
  SELECT MaSach, SLTon, GiaBan INTO v_MaSach, v_SLTon,v_GiaBan
  FROM Sach
  WHERE MaSach = in_MaSach;
  --
  IF(v_MaHD = NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20001,'Hóa ??n không t?n t?i!');
  END IF;
  IF(v_MaSach = NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20002,'Sách không t?n t?i');
  END IF;
  IF(in_SL <= v_SLTon)
    Then
      v_SLConLai:=v_SLTon - in_SL;
      UPDATE SACH SET SLTON = v_SLConLai WHERE MASACH = in_MaSach;
      v_ThanhTien:=in_SL*v_GiaBan;
      INSERT INTO CTHD VALUES(in_MaHD,in_MaSach,in_SL,v_ThanhTien);
      COMMIT;
  ELSE RAISE_APPLICATION_ERROR(-20003,'S? l??ng sách trong kho không ??');
  END IF;
END;
----4.	Thêm chi ti?t phi?u nh?p:
create or replace PROCEDURE Them_CTPN(in_MaPN PHIEUNHAP.MAPHIEUNHAP%TYPE, in_MaSach SACH.MaSach%TYPE,in_SL CTPHIEUNHAP.SOLUONG%TYPE, in_GiaNhap CTPHIEUNHAP.GIANHAP%TYPE)
AS
  v_MaPN varchar2(10);
  v_MaSach varchar2(10);
  v_SLTon number;
  v_SLMoi number;
  v_ThanhTien number;
BEGIN
  --Lay MaPhieuNHap--
  SELECT MaPhieuNhap INTO v_MaPN
  FROM PHIEUNHAP
  WHERE MaPhieuNhap = in_MaPN;
  --Lay Ma sach--
  SELECT MaSach,SLTon INTO v_MaSach, v_SLTon
  FROM Sach
  WHERE MaSach = in_MaSach;
  --
  IF(v_MaPN = NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20005,'Phi?u nh?p không t?n t?i!');
  END IF;
  IF(v_MaSach = NULL)
    THEN
      RAISE_APPLICATION_ERROR(-20002,'Sách không t?n t?i');
  END IF;
  v_SLMoi:=v_SLTon + in_SL;
  UPDATE SACH SET SLTON = v_SLMoi WHERE MaSach = in_MaSach;
  v_ThanhTien:=in_SL*in_GiaNhap;
  INSERT INTO CTPHIEUNHAP VALUES(in_MaPN,in_MaSach,in_SL,in_GiaNhap,v_ThanhTien);
  COMMIT;
END;
----5.	Tinh T?ng ti?n hóa ??n (dùng function tính ti?n gi?m khi có mã khuy?n mãi tr??c).
CREATE OR REPLACE PROCEDURE Tinh_TongHD(in_MaHD HOADON.MaHD%TYPE)
AS
v_TongTienHD number := 0;
v_TienGiam number:=0;
  v_NgayMua date;
  v_MaKM varchar2(10);
  v_SoPTG number;
  v_kmTuNG Date;
  v_kmDenNG Date;
  v_DkKM number;
BEGIN
  --Tinh Tong tien HD khi chua kiem tra ma khuyen mai--
  SELECT SUM(ct.THANHTIEN) INTO v_TongTienHD
  FROM CTHD ct
  WHERE ct.MAHD = in_MaHD;
  --Lay nhung thong tin can trong hoa don--
  SELECT MAKM, NGAYMUASACH  into v_MaKM,v_NgayMua
  FROM HOADON
  WHERE HOADON.MAHD = in_MaHD;
  IF(v_MaKM IS NOT NULL)
    THEN
      --Lay nhung thong tin dieu kien trong khuyen mai--
      SELECT SOPHANTRAMGIAM, KMTUNGAY,KMDENNGAY, DIEUKIENKM INTO v_SoPTG, v_kmTuNG, v_kmDenNG, v_DKKM
      FROM KHUYENMAI
      WHERE MAKM = v_MaKM;
      IF (v_NgayMua >= v_kmTuNg and v_NgayMua <= v_kmDenNG and v_TongTienHD >= v_DkKM)
        THEN
          v_TienGiam:=v_TongTienHD*(v_SoPTG/100);
      END IF;
      v_TongTienHD:=(v_TongTienHD-v_TienGiam);
      UPDATE HOADON
      SET TONGTIENHD = v_TongTienHD
      WHERE HOADON.MAHD = in_MaHD;
      COMMIT;
  ELSE
    UPDATE HOADON
    SET TONGTIENHD = v_TongTienHD
    WHERE HOADON.MAHD = in_MaHD;
    COMMIT;
  END IF;
END;
--
execute TINH_TONGHD('HD013');
---6. Tính t?ng Phi?u nh?p:
create or replace PROCEDURE Tinh_TongPN(in_MaPN PHIEUNHAP.MaPhieuNhap%TYPE)
AS
  v_TongTienPN number := 0;
BEGIN
  SELECT SUM(ct.THANHTIEN) INTO v_TongTienPN
  FROM CTPHIEUNHAP ct
  WHERE ct.MaPhieuNhap = in_MaPN;
  UPDATE PHIEUNHAP
  SET TongTienPN = v_TongTienPN
  WHERE MaPhieuNhap = in_MaPN;
  COMMIT;
END;
execute TINH_TONGPN('PN001');
-----7.	Xóa chi ti?t hóa ??n:
create or replace PROCEDURE Xoa_CTHD(in_MaHD HOADON.MaHD%TYPE, in_MaSach SACH.MaSach%TYPE)
AS
  v_SLTon number;
  v_SL number; --So Luong sach trong cthd--
  v_SLConLai number;
BEGIN
  --Lay so luong ton trong kho--
  SELECT SLTon INTO v_SLTon
  FROM Sach
  WHERE MaSach = in_MaSach;
  --Lay SL dang co trong CTHD--
  SELECT SOLUONG into v_SL
  FROM CTHD
  WHERE MaHD = in_MaHD and MaSach = in_MaSach;
  --Xoa--
  v_SLConLai:=v_SLTon + v_SL;
  UPDATE SACH
  SET SLTON =v_SLConLai
  WHERE MaSach = in_MaSach;
  DELETE FROM CTHD WHERE MaHD = in_MaHD and MaSach = in_MaSach;
  COMMIT;
END;
---8.	Xóa chi ti?t phi?u nh?p:
create or replace PROCEDURE Xoa_CTPN(in_MaPN PHIEUNHAP.MaPhieuNhap%TYPE, in_MaSach SACH.MaSach%TYPE)
AS
  v_SLTon number;
  v_SL number; --So Luong sach trong CTPN--
  v_SLMoi number;
BEGIN
  --Lay so luong ton trong kho--
  SELECT SLTon INTO v_SLTon
  FROM Sach
  WHERE MaSach = in_MaSach;
  --Lay SL dang co trong CTHD--
  SELECT SoLuong into v_SL
  FROM CTPHIEUNHAP
  WHERE MaPhieuNhap = in_MaPN and MaSach = in_MaSach;
  --Xoa--
  v_SLMoi:=v_SLTon - v_SL;
  UPDATE SACH
  SET SLTon = v_SLMoi
  WHERE MaSach = in_MaSach;
  DELETE FROM CTPHIEUNHAP WHERE MaPhieuNhap = in_MaPN and MaSach = in_MaSach;
  COMMIT;
END;
------
select MANV, Sum(TONGTIENHD) AS Doanhthu 
from  HOADON
where EXTRACT (YEAR FROM NGAYMUASACH)= '2019'
GROUP BY MANV
HAVING SUM(TONGTIENHD)>5000000;

-----



