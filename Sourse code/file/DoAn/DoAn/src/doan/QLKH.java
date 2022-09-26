/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
/**
 *
 * @author hoang
 */
public class QLKH extends javax.swing.JFrame {

    /**
     * Creates new form QLKH
     */
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public QLKH() {
        initComponents();
        KetNoiCSDL();
        Load_data_KH();
    }
    public JPanel getJPN(){
        return jpnKH; 
    }
    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void Load_data_KH(){
        try{
            ps = conn.prepareStatement("SELECT * FROM KHACHHANG ");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaKH"));
                        v1.add(rs.getString("TenKH"));
                        v1.add(rs.getString("SDT"));
                        v1.add(rs.getString("Email"));
                        v1.add(rs.getString("GioiTinh"));
                        v1.add(rs.getString("DChi"));
                        v1.add(rs.getString("LoaiKH"));
                        v1.add(rs.getDate("NgSinh"));
                        v1.add(rs.getString("CMND"));
                  }
                    model.addRow(v1);
                   listKH.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void Load_data_KH(String MaKH){
        try{
            ps = conn.prepareStatement("SELECT * FROM KHACHHANG WHERE MaKH = ?");
            ps.setString(1, MaKH);
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaKH"));
                        v1.add(rs.getString("TenKH"));
                        v1.add(rs.getString("SDT"));
                        v1.add(rs.getString("Email"));
                        v1.add(rs.getString("GioiTinh"));
                        v1.add(rs.getString("DChi"));
                        v1.add(rs.getString("LoaiKH"));
                        v1.add(rs.getDate("NgSinh"));
                        v1.add(rs.getString("CMND"));
                  }
                    model.addRow(v1);
                   listKH.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void LamMoi(){
        JTextMaKH.setText("");
        jTextTenKH.setText("");
        jTextSDT.setText("");
        jTextEmail.setText("");
        jRadioNam.setSelected(false);
        jRadioNu.setSelected(false);
        jTextDChi.setText("");
        jRadioVip.setSelected(false);
        jRadioNormal.setSelected(false);
        jTextCMND.setText("");
        jDate.setDate(null);
    }
    public void LamMoiTable(){
        try{
            ps = conn.prepareStatement("SELECT * FROM KHACHHANG ");
            rs = ps.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) listKH.getModel();
            model.setRowCount(0);
            while (rs.next()){
                    Vector v1 = new Vector();
                    for(int i=1;i<=c;i++){
                        v1.add(rs.getString("MaKH"));
                        v1.add(rs.getString("TenKH"));
                        v1.add(rs.getString("SDT"));
                        v1.add(rs.getString("Email"));
                        v1.add(rs.getString("GioiTinh"));
                        v1.add(rs.getString("DChi"));
                        v1.add(rs.getString("LoaiKH"));
                        v1.add(rs.getDate("NgSinh"));
                        v1.add(rs.getString("CMND"));
                  }
                    model.addRow(v1);
                   listKH.setModel(model);
                }
        }
        catch (SQLException ex){
            Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnKH = new javax.swing.JPanel();
        JTextMaKH = new javax.swing.JTextField();
        JButtonTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listKH = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextTenKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextEmail = new javax.swing.JTextField();
        jTextDChi = new javax.swing.JTextField();
        jTextCMND = new javax.swing.JTextField();
        jRadioVip = new javax.swing.JRadioButton();
        jRadioNormal = new javax.swing.JRadioButton();
        jDate = new com.toedter.calendar.JDateChooser();
        jButtonThem = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonCapNhat = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jRadioNam = new javax.swing.JRadioButton();
        jRadioNu = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTextMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextMaKHActionPerformed(evt);
            }
        });

        JButtonTim.setBackground(new java.awt.Color(230, 175, 139));
        JButtonTim.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        JButtonTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        JButtonTim.setText("Tìm");
        JButtonTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonTimActionPerformed(evt);
            }
        });

        listKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên", "Số điện thoại", "Email", "Giới tính", "Địa chỉ", "Loại khách hàng", "Ngày sinh", "CMND"
            }
        ));
        listKH.setInheritsPopupMenu(true);
        listKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listKHMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listKHMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listKH);

        jLabel2.setText("Mã khách hàng");

        jTextTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenKHActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Email");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Loại khách hàng");

        jLabel8.setText("CMND");

        jLabel9.setText("Ngày sinh");

        jTextCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCMNDActionPerformed(evt);
            }
        });

        jRadioVip.setText("Thân Thiết");

        jRadioNormal.setText("Thường");
        jRadioNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioNormalActionPerformed(evt);
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

        jButtonCapNhat.setBackground(new java.awt.Color(230, 175, 139));
        jButtonCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButtonCapNhat.setText("Cập nhập");
        jButtonCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCapNhatActionPerformed(evt);
            }
        });

        jButtonReset.setBackground(new java.awt.Color(230, 175, 139));
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButtonReset.setText("Làm mới");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jLabel10.setText("Giới Tính");

        jRadioNam.setText("Nam");

        jRadioNu.setText("Nữ");

        jPanel1.setBackground(new java.awt.Color(230, 175, 139));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ THÔNG TIN KHÁCH HÀNG");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setText("THÔNG TIN KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));
        jPanel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setText("DANH SÁCH KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(230, 175, 139));
        jButton1.setText("Tìm Nâng Cao");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnKHLayout = new javax.swing.GroupLayout(jpnKH);
        jpnKH.setLayout(jpnKHLayout);
        jpnKHLayout.setHorizontalGroup(
            jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKHLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnKHLayout.createSequentialGroup()
                                .addComponent(jTextTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnKHLayout.createSequentialGroup()
                                .addComponent(jRadioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnKHLayout.createSequentialGroup()
                                .addComponent(jRadioVip, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnKHLayout.setVerticalGroup(
            jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKHLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnKHLayout.createSequentialGroup()
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTextMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JButtonTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioNam)
                            .addComponent(jRadioNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioVip)
                            .addComponent(jRadioNormal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTextMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextMaKHActionPerformed

    private void JButtonTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonTimActionPerformed
        // TODO add your handling code here:
      StringBuilder sb = new StringBuilder();
        if (JTextMaKH.getText().equals("")){
            sb.append("Mã khách hàng không được để trống!!!");
           JTextMaKH.setBackground(Color.red);
        } else {
             JTextMaKH.setBackground(Color.white);
        }
        if (sb.length() > 0){
           JOptionPane.showMessageDialog(this, sb);
           return;
        }
        try{
            KhachHang kh = khmodify.find(JTextMaKH.getText());
        
        if (kh != null){
        // Xuất thông tin
            int selectedIndex = listKH.getSelectedRow();

            JTextMaKH.setText(kh.getMaKH());
            jTextTenKH.setText(kh.getTenKH());
            jTextSDT.setText(kh.getSDT());
            jTextEmail.setText(kh.getEmail());
            if(kh.getGioiTinh().equals("Nam")){
                jRadioNam.setSelected(true);
                jRadioNu.setSelected(false);
            }
            else if(kh.getGioiTinh().equals("Nu") || kh.getGioiTinh().equals("Nữ")){
                jRadioNam.setSelected(false);
                jRadioNu.setSelected(true);
            }
            else{
                jRadioNam.setSelected(false);
                jRadioNu.setSelected(false);
            }
            jTextDChi.setText(kh.getDchi());
            jDate.setDate(kh.getNgSinh());
            jTextCMND.setText(kh.getCMND());
            if(kh.getLoaiKH().equals("Than thiet") ||kh.getLoaiKH().equals("Thân thiết") || kh.getLoaiKH().equals("Thân Thiết") ){
                jRadioVip.setSelected(true);
                jRadioNormal.setSelected(false);
            }
            else if(kh.getLoaiKH().equals("Thuong") || kh.getLoaiKH().equals("Thường")){
                jRadioVip.setSelected(false);
                jRadioNormal.setSelected(true);
            }
            else{
                jRadioVip.setSelected(false);
                jRadioNormal.setSelected(false);
            }
            Load_data_KH(kh.getMaKH());
        } 
        else JOptionPane.showMessageDialog(this, "Khách hàng tìm kiếm không tồn tại!");
        } catch (Exception e){
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
         e.printStackTrace();
      }
    }//GEN-LAST:event_JButtonTimActionPerformed

    private void jTextTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenKHActionPerformed

    private void jRadioNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioNormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioNormalActionPerformed

    private void listKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKHMouseClicked
        // TODO add your handling code here:
        LamMoi();
        int selectedIndex = listKH.getSelectedRow();
        listKH.setColumnSelectionInterval(0,8);
        JTextMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
        jTextTenKH.setText(listKH.getValueAt(selectedIndex, 1).toString());
        jTextSDT.setText(listKH.getValueAt(selectedIndex, 2).toString());
        jTextEmail.setText(listKH.getValueAt(selectedIndex, 3).toString());
        if(listKH.getValueAt(selectedIndex, 4).equals("Nam"))
            jRadioNam.setSelected(true);
        if(listKH.getValueAt(selectedIndex, 4).equals("Nu") || listKH.getValueAt(selectedIndex, 4).equals("Nữ"))
            jRadioNu.setSelected(true);
        jTextDChi.setText(listKH.getValueAt(selectedIndex, 5).toString());
        if(listKH.getValueAt(selectedIndex, 6).equals("Than thiet") || listKH.getValueAt(selectedIndex, 6).equals("Thân thiết") || listKH.getValueAt(selectedIndex, 6).equals("Thân Thiết"))
            jRadioVip.setSelected(true);
        if(listKH.getValueAt(selectedIndex, 6).equals("Thuong") || listKH.getValueAt(selectedIndex, 6).equals("Thường"))
            jRadioNormal.setSelected(true);
        jTextCMND.setText(listKH.getValueAt(selectedIndex, 8).toString());
        jDate.setDate((java.util.Date) listKH.getValueAt(selectedIndex, 7));
    }//GEN-LAST:event_listKHMouseClicked

    private void listKHMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKHMouseReleased
//        LamMoi();
//        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
//            int selectedIndex = listKH.getSelectedRow();
//            listKH.setColumnSelectionInterval(0,7);
//            listKH.setColumnSelectionInterval(0,7);
//            JTextMaKH.setText(listKH.getValueAt(selectedIndex, 0).toString());
//            jTextTenKH.setText(listKH.getValueAt(selectedIndex, 1).toString());
//            jTextSDT.setText(listKH.getValueAt(selectedIndex, 2).toString());
//            jTextEmail.setText(listKH.getValueAt(selectedIndex, 3).toString());
//            jTextDChi.setText(listKH.getValueAt(selectedIndex, 4).toString());
//            if(listKH.getValueAt(selectedIndex, 5).equals("Vip") || listKH.getValueAt(selectedIndex, 5).equals("VIP"));
//                jRadioVip.setSelected(true);
//            if(listKH.getValueAt(selectedIndex, 5).equals("Normal") || listKH.getValueAt(selectedIndex, 5).equals("NORMAL"));
//                jRadioNormal.setSelected(true);
//            jTextCMND.setText(listKH.getValueAt(selectedIndex, 7).toString());
//            jDate.setDate((java.util.Date) listKH.getValueAt(selectedIndex, 6));
//            Date date = null;
//            try {
//                date = new SimpleDateFormat("yyyy-MM-dd").parse((String)listKH.getValueAt(selectedIndex, 6));
//            } catch (ParseException ex) {
//                Logger.getLogger(QLKH.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            jDate.setDate(date);  
//       }
    }//GEN-LAST:event_listKHMouseReleased

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // TODO add your handling code here:
        LamMoi();
        LamMoiTable();
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCapNhatActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMaKH(JTextMaKH.getText());
            kh.setTenKH(jTextTenKH.getText());
            kh.setSDT(jTextSDT.getText());
            kh.setEmail(jTextEmail.getText());
            if(jRadioNam.isSelected()){
                kh.setGioiTinh(jRadioNam.getText());
            }
            if(jRadioNu.isSelected()){
                kh.setGioiTinh(jRadioNu.getText());
            }
            kh.setDchi(jTextDChi.getText());
            if(jRadioVip.isSelected()){
                kh.setLoaiKH(jRadioVip.getText());
            }
            if(jRadioNormal.isSelected()){
                kh.setLoaiKH(jRadioNormal.getText());
            }
            if(jDate.getDate() != null){
                java.util.Date birthday = jDate.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                kh.setNgSinh(sqlbd);
            }
            kh.setCMND(jTextCMND.getText());
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn cập nhật khách hàng?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                khmodify.UpdateKH(kh);
                JOptionPane.showMessageDialog(this, "Đã cập nhật thành công");
            }
            else JOptionPane.showMessageDialog(this, "Chưa cập nhật");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonCapNhatActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa khách hàng?", "Xóa", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                khmodify.DeleteKH(JTextMaKH.getText());
                JOptionPane.showMessageDialog(this,"Đã xóa khách hàng thành công");
            }
            else{
                JOptionPane.showMessageDialog(this,"khách hàng chưa được xóa");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        StringBuilder sb = new StringBuilder();
        if(JTextMaKH.getText().equals("")){
            sb.append("!!Mã khách hàng không được để trống!!");
            JTextMaKH.setBackground(Color.red);
        }
        else{
            JTextMaKH.setBackground(Color.white);
        }
        if(sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{
            KhachHang kh = new KhachHang();
            kh.setMaKH(JTextMaKH.getText());
            kh.setTenKH(jTextTenKH.getText());
            kh.setSDT(jTextSDT.getText());
            kh.setEmail(jTextEmail.getText());
            if(jRadioNam.isSelected()){
                kh.setGioiTinh(jRadioNam.getText());
            }
            if(jRadioNu.isSelected()){
                kh.setGioiTinh(jRadioNu.getText());
            }
            kh.setDchi(jTextDChi.getText());
            if(jRadioVip.isSelected()){
                kh.setLoaiKH(jRadioVip.getText());
            }
            if(jRadioNormal.isSelected()){
                kh.setLoaiKH(jRadioNormal.getText());
            }
            if(jDate.getDate() != null){
                java.util.Date birthday = jDate.getDate();
                java.sql.Date sqlbd = new java.sql.Date(birthday.getTime());
                kh.setNgSinh(sqlbd);
            }
            kh.setCMND(jTextCMND.getText());
            khmodify.InsertKH(kh);
            JOptionPane.showMessageDialog(this, "Đã thêm thành công.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jTextCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCMNDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new TimKiemKH();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    
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
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonTim;
    private javax.swing.JTextField JTextMaKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCapNhat;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoa;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioNam;
    private javax.swing.JRadioButton jRadioNormal;
    private javax.swing.JRadioButton jRadioNu;
    private javax.swing.JRadioButton jRadioVip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextCMND;
    private javax.swing.JTextField jTextDChi;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextSDT;
    private javax.swing.JTextField jTextTenKH;
    private javax.swing.JPanel jpnKH;
    private javax.swing.JTable listKH;
    // End of variables declaration//GEN-END:variables
}
