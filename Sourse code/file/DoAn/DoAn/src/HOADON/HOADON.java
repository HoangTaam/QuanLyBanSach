/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HOADON;
import static BaoCaoForm.BCForm.disableAccessWarnings;
import ChonKH.KHForm;
import ChonKM.KMFrame;
import DANGNHAP.TAIKHOAN;
import doan.JDBCConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author hoang
 */
public class HOADON extends javax.swing.JFrame {

    /**
     * Creates new form HOADON
     */
    TAIKHOAN tk;
    KHForm khk;
    public JPanel getJPN(){
        return jpnHD;
    }
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public HOADON() {
        initComponents();
        KetNoiCSDL();
        Load_data_HD();
    }
    
    public void NhanDLVe(String MaNV){
        jMaKH.setText(MaNV);
    }
    public void NhanDLVeMaKM(String MaKM){
        jMaKM.setText(MaKM);
    }
    public HOADON(TAIKHOAN in_tk) {
        initComponents();
        KetNoiCSDL();
        Load_data_HD();
        tk = in_tk;
    }

    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Load_data_HD(){
        try{
            ps = conn.prepareStatement("SELECT * FROM HOADON ");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listHD.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaHD"));
                        v1.add(rs.getDate("NgayMuaSach"));
                        v1.add(rs.getString("TongTienHD"));
                        v1.add(rs.getString("MaNV"));
                        v1.add(rs.getString("MaKH"));
                        v1.add(rs.getString("MaKM"));
                  }
                    model.addRow(v1);
                   listHD.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Load_data_HD(String MaHD){
        try{
            ps = conn.prepareStatement("SELECT * FROM HOADON WHERE MaHD = ?");
            ps.setString(1, MaHD);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listHD.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                         v1.add(rs.getString("MaHD"));
                        v1.add(rs.getDate("NgayMuaSach"));
                        v1.add(rs.getString("TongTienHD"));
                        v1.add(rs.getString("MaNV"));
                        v1.add(rs.getString("MaKH"));
                        v1.add(rs.getString("MaKM"));
                  }
                    model.addRow(v1);
                   listHD.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void LamMoi(){
        jMaHD.setText("");
        jNgayMua.setDate(null);
        jMaNV.setText("");
        jMaKH.setText("");
        jMaKM.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jNgayMua = new com.toedter.calendar.JDateChooser();
        jMaHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMaKH = new javax.swing.JTextField();
        jMaKM = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonCN = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listHD = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        InHD = new javax.swing.JButton();
        jMaNV = new javax.swing.JTextField();
        jChonKH = new javax.swing.JButton();
        jButtonChonMaNV = new javax.swing.JButton();
        jButtonChonKM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Mã hóa đơn");

        jLabel3.setText("Ngày mua sách");

        jLabel4.setText("Mã nhân viên");

        jLabel5.setText("Mã khách hàng");

        jLabel6.setText("Mã khuyến mãi");

        jButton1.setBackground(new java.awt.Color(230, 175, 139));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonThem.setBackground(new java.awt.Color(230, 175, 139));
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        jButtonXoa.setBackground(new java.awt.Color(230, 175, 139));
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButtonXoa.setText("Xóa");
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonCN.setBackground(new java.awt.Color(230, 175, 139));
        jButtonCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonCN.setText("Cập nhật");
        jButtonCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCNActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(230, 175, 139));
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        listHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày mua sách", "Tổng tiền ", "Mã nhân viên", "Mã khách hàng", "Mã khuyến mãi"
            }
        ));
        listHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listHD);

        jButton2.setBackground(new java.awt.Color(230, 175, 139));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/eye.png"))); // NOI18N
        jButton2.setText("Xem chi tiết");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 102, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/invoice.png"))); // NOI18N
        jButton3.setText("Tính tổng tiền");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(230, 175, 139));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("THÔNG TIN HÓA ĐƠN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DANH SÁCH HÓA ĐƠN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InHD.setBackground(new java.awt.Color(255, 102, 51));
        InHD.setText("In hóa đơn");
        InHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InHDActionPerformed(evt);
            }
        });

        jChonKH.setText("...");
        jChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChonKHActionPerformed(evt);
            }
        });

        jButtonChonMaNV.setText("...");
        jButtonChonMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonMaNVActionPerformed(evt);
            }
        });

        jButtonChonKM.setText("...");
        jButtonChonKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChonKMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnHDLayout = new javax.swing.GroupLayout(jpnHD);
        jpnHD.setLayout(jpnHDLayout);
        jpnHDLayout.setHorizontalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnHDLayout.createSequentialGroup()
                                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnHDLayout.createSequentialGroup()
                                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jMaKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpnHDLayout.createSequentialGroup()
                                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHDLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHDLayout.createSequentialGroup()
                                        .addComponent(jButtonChonMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnHDLayout.createSequentialGroup()
                                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jButtonChonKM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(jChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                        .addComponent(InHD, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnHDLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnHDLayout.createSequentialGroup()
                                .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnHDLayout.setVerticalGroup(
            jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHDLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnHDLayout.createSequentialGroup()
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNgayMua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonChonMaNV)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnHDLayout.createSequentialGroup()
                                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jChonKH))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonChonKM)))
                            .addComponent(InHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jpnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if (jMaHD.getText().equals("")){
            sb.append("Mã hóa đơn không được để trống!!!");
           jMaHD.setBackground(Color.red);
        } else {
             jMaHD.setBackground(Color.white);
        }
        if (sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try{
            HD hd = HDmodify.find(jMaHD.getText());
            if (hd != null){
            jMaHD.setText(hd.getMaHD());
            jNgayMua.setDate(hd.getNgayMuaSach());
            jMaNV.setText(hd.getMaNV());
            jMaKH.setText(hd.getMaKH());
            jMaKM.setText(hd.getMaKM());
            Load_data_HD(hd.getMaHD());
            }
            else JOptionPane.showMessageDialog(this, "Hóa đơn tìm kiếm không tồn tại!");
        } catch (Exception e){
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
         e.printStackTrace();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        LamMoi();
        Load_data_HD();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa hóa đơn không?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                HDmodify.DeleteHD(jMaHD.getText());
                JOptionPane.showMessageDialog(this,"Đã xóa hóa đơn thành công");
            }
            else{
                JOptionPane.showMessageDialog(this,"Hóa đơn chưa được xóa");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            HD hd = new HD();
            hd.setMaHD(jMaHD.getText());
            if(jNgayMua.getDate() != null){
                java.util.Date birthday = jNgayMua.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                hd.setNgayMuaSach(sqlbd);
            }
            hd.setMaNV(jMaNV.getText());
            hd.setMaKH(jMaKH.getText());
            hd.setMaKM(jMaKM.getText());
            HDmodify.InsertHD(hd);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCNActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            HD hd = new HD();
            hd.setMaHD(jMaHD.getText());
            if(jNgayMua.getDate() != null){
                java.util.Date birthday = jNgayMua.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                hd.setNgayMuaSach(sqlbd);
            }
            hd.setMaNV(jMaNV.getText());
            hd.setMaKH(jMaKH.getText());
            hd.setMaKM(jMaKM.getText());
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn cập nhật hóa đơn không?", "cập nhật", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                HDmodify.UpdateHD(hd);
                JOptionPane.showMessageDialog(this,"Đã Cập nhật thành công.");
            }
            else{
                JOptionPane.showMessageDialog(this,"Hóa đơn chưa được cập nhật");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        jpnHD.removeAll();
        jpnHD.setLayout(new BorderLayout());
        jpnHD.add(new CTHD(jMaHD.getText()).getJPN());
        jpnHD.validate();
        jpnHD.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
           HDmodify.Tinh_TongHD(jMaHD.getText());
           JOptionPane.showMessageDialog(this, "Đã tính thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listHDMouseClicked
        // TODO add your handling code here:
        try{
        LamMoi();
        int selectedIndex = listHD.getSelectedRow();
        listHD.setColumnSelectionInterval(0,5);
        jMaHD.setText(listHD.getValueAt(selectedIndex, 0).toString());
        jNgayMua.setDate((java.util.Date) listHD.getValueAt(selectedIndex, 1));
        jMaNV.setText(listHD.getValueAt(selectedIndex, 3).toString());
        jMaKH.setText(listHD.getValueAt(selectedIndex, 4).toString());
        jMaKM.setText(listHD.getValueAt(selectedIndex, 5).toString());
        }
        catch(Exception e){
        }
    }//GEN-LAST:event_listHDMouseClicked

    private void InHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InHDActionPerformed
        disableAccessWarnings();
        StringBuilder sb = new StringBuilder();
        if(jMaHD.getText().equals("")){
            sb.append("!!Mã hóa đơn không được để trống!!");
            jMaHD.setBackground(Color.red);
        }
        else{
            jMaHD.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");  

        String MaHD =jMaHD.getText();
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Mã hóa đơn",MaHD);
        
        JasperDesign jd  = JRXmlLoader.load("C:/file/file report/hoadon.jrxml");
        JasperReport jr = JasperCompileManager.compileReport("C:/file/file report/hoadon.jrxml");
        JasperPrint  jp = JasperFillManager.fillReport(jr,parameters,con);
        
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_InHDActionPerformed
    
    private void jChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChonKHActionPerformed
        // TODO add your handling code here: 
        khk = new KHForm();
        khk.TruyenDLDi(this);
    }//GEN-LAST:event_jChonKHActionPerformed

    private void jButtonChonMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonMaNVActionPerformed
        // TODO add your handling code here:
        jMaNV.setText(tk.getMaNV());
    }//GEN-LAST:event_jButtonChonMaNVActionPerformed

    private void jButtonChonKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChonKMActionPerformed
        // TODO add your handling code here:
        KMFrame km = new KMFrame();
        km.TruyenDL(this);
    }//GEN-LAST:event_jButtonChonKMActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOADON().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InHD;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCN;
    private javax.swing.JButton jButtonChonKM;
    private javax.swing.JButton jButtonChonMaNV;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JButton jChonKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jMaHD;
    private javax.swing.JTextField jMaKH;
    private javax.swing.JTextField jMaKM;
    private javax.swing.JTextField jMaNV;
    private com.toedter.calendar.JDateChooser jNgayMua;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnHD;
    private javax.swing.JTable listHD;
    // End of variables declaration//GEN-END:variables
}
