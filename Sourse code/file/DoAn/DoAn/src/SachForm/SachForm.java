/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SachForm;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DO THI THANH AN
 */
public class SachForm extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs; 
    
    public SachForm() {
        initComponents();
        KetNoiCSDL();
        Sach_Load();
    }
    public JPanel getJPN(){
        return jpnSach;
    }
    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    public void Sach_Load(){
           
        try {
            ps = conn.prepareStatement("SELECT * FROM SACH ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
          
            DefaultTableModel model = (DefaultTableModel) ListSach.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                Vector v1 = new Vector();
                for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MaSach"));
                    v1.add(rs.getString("TenSach"));
                    v1.add(rs.getString("TenTG"));
                    v1.add(rs.getDate("NamXB"));
                    v1.add(rs.getInt("SLTon"));
                    v1.add(rs.getInt("GiaBan"));
                    v1.add(rs.getString("MaTL"));
                   
              }
                model.addRow(v1);
               ListSach.setModel(model);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
  public void LamMoi(){
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtTenTG.setText("");
        jdNamXB.setDate(null);
        txtSLTon.setText("");
        txtGiaBan.setText("");
        txtMaTL.setText("");   
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtTenTG = new javax.swing.JTextField();
        txtSLTon = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtMaTL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListSach = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jdNamXB = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã sách");

        jLabel2.setText("Tên sách");

        jLabel3.setText("Tên tác giả");

        jLabel4.setText("Năm xuất bản");

        jLabel5.setText("Số lượng tồn");

        jLabel7.setText("Giá bán");

        jLabel8.setText("Mã thể loại");

        txtMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSachActionPerformed(evt);
            }
        });

        txtTenTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTGActionPerformed(evt);
            }
        });

        txtGiaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaBanActionPerformed(evt);
            }
        });

        ListSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Tên tác giả", "Năm xuất bản", "Số lượng tồn", "Giá bán", "Mã thể loại"
            }
        ));
        ListSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListSachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListSach);
        if (ListSach.getColumnModel().getColumnCount() > 0) {
            ListSach.getColumnModel().getColumn(1).setResizable(false);
            ListSach.getColumnModel().getColumn(2).setResizable(false);
            ListSach.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton5.setBackground(new java.awt.Color(230, 175, 139));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/find.png"))); // NOI18N
        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(230, 175, 139));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ SÁCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel3.setBackground(new java.awt.Color(230, 175, 139));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THÔNG TIN SÁCH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBackground(new java.awt.Color(230, 175, 139));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DANH SÁCH CÁC QUYỂN SÁCH");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jButton1.setBackground(new java.awt.Color(230, 175, 139));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add-icon.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(230, 175, 139));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Trash-can-icon.png"))); // NOI18N
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(230, 175, 139));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit.png"))); // NOI18N
        jButton3.setText("Cập nhật");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(230, 175, 139));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-right-icon.png"))); // NOI18N
        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnSachLayout = new javax.swing.GroupLayout(jpnSach);
        jpnSach.setLayout(jpnSachLayout);
        jpnSachLayout.setHorizontalGroup(
            jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSachLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpnSachLayout.createSequentialGroup()
                                .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))))
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(52, 52, 52)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnSachLayout.setVerticalGroup(
            jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSachLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnSachLayout.createSequentialGroup()
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdNamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSLTon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 222, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSachActionPerformed

    private void txtTenTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTGActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
          
        tacvusach tv = new tacvusach();
        ClassSach S = tv.find(txtMaSach.getText());
        
        if (S != null){
        // Xuất thông tin
        int selectedIndex = ListSach.getSelectedRow();
        
        txtMaSach.setText(S.getMaSach());
        txtTenSach.setText(S.getTenSach());
        txtTenTG.setText(S.getTenTG());
        jdNamXB.setDate(S.getNamXB());
        txtSLTon.setText(S.getSLTon());
        txtGiaBan.setText(S.getGiaBan());
        txtMaTL.setText(S.getMaTL());   
        
       } else 
       
        JOptionPane.showMessageDialog(this, "Sách tìm kiếm không tồn tại!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try{  
        ClassSach S = new ClassSach();
        S.setMaSach(txtMaSach.getText());
        S.setTenSach(txtTenSach.getText());
        S.setTenTG(txtTenTG.getText());
        
         if(jdNamXB.getDate() != null ){
            java.util.Date utilStartDate = jdNamXB.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            S.setNamXB(sqlStartDate);
        }
        
        S.setSLTon(txtSLTon.getText());
        S.setGiaBan(txtGiaBan.getText());
        S.setMaTL(txtMaTL.getText());

        tacvusach dao = new tacvusach();
        dao.insert(S);    
        JOptionPane.showMessageDialog(this, "Sách được thêm vào thành công!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          
      }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
      try{  
        
        tacvusach dao = new tacvusach();
        int result = JOptionPane.showConfirmDialog(this,"Bạn chắc chắn muốn xóa sách này?","Xác nhận", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
         dao.delete(txtMaSach.getText());
        JOptionPane.showMessageDialog(this, "Sách đã xóa thành công!");
        } else {
        JOptionPane.showMessageDialog(this, "Sách viên chưa được xóa!");
        }
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          e.printStackTrace();
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtMaSach.getText().equals("")){
            sb.append("Mã sách không được để trống!!!");
            txtMaSach.setBackground(Color.red);
        } else {
             txtMaSach.setBackground(Color.white);
        }
        if (sb.length() > 0){
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        
        
        
        try{  
       
        tacvusach dao = new tacvusach();
        ClassSach S = new ClassSach();
        
        S.setMaSach(txtMaSach.getText());
        S.setTenSach(txtTenSach.getText());
        S.setTenTG(txtTenTG.getText());
        
         if(jdNamXB.getDate() != null ){
            java.util.Date utilStartDate = jdNamXB.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            S.setNamXB(sqlStartDate);
        }
        
        S.setSLTon(txtSLTon.getText());
        S.setGiaBan(txtGiaBan.getText());
        S.setMaTL(txtMaTL.getText());

        
        dao.update(S);  
        
        JOptionPane.showMessageDialog(this, "Sách được cập nhật vào thành công!");
      } catch (Exception e){
          JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
          
      }   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        LamMoi();
        try {
            ps = conn.prepareStatement("SELECT * FROM SACH ");
            rs = ps.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
          
            DefaultTableModel model = (DefaultTableModel) ListSach.getModel();
            model.setRowCount(0);
            
            while (rs.next()){
                Vector v1 = new Vector();
                for(int i=1;i<=c;i++){
                    v1.add(rs.getString("MaSach"));
                    v1.add(rs.getString("TenSach"));
                    v1.add(rs.getString("TenTG"));
                    v1.add(rs.getDate("NamXB"));
                    v1.add(rs.getString("SLTon"));
                    v1.add(rs.getString("GiaBan"));
                    v1.add(rs.getString("MaTL")); 
              }
                model.addRow(v1);
               ListSach.setModel(model);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SachForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ListSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListSachMouseClicked
        LamMoi();
        try{
            int selectedIndex = ListSach.getSelectedRow();
            ListSach.setColumnSelectionInterval(0,6);
            txtMaSach.setText(ListSach.getValueAt(selectedIndex, 0).toString());
            txtTenSach.setText(ListSach.getValueAt(selectedIndex, 1).toString());
            txtTenTG.setText(ListSach.getValueAt(selectedIndex, 2).toString());
            jdNamXB.setDate((Date) ListSach.getValueAt(selectedIndex, 3));
            txtSLTon.setText(ListSach.getValueAt(selectedIndex, 4).toString());
            txtGiaBan.setText(ListSach.getValueAt(selectedIndex, 5).toString());
            txtMaTL.setText(ListSach.getValueAt(selectedIndex, 6).toString());
        }
        catch(Exception e){
        }           
    }//GEN-LAST:event_ListSachMouseClicked

    private void txtGiaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaBanActionPerformed

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
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SachForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SachForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListSach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdNamXB;
    private javax.swing.JPanel jpnSach;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaTL;
    private javax.swing.JTextField txtSLTon;
    private javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtTenTG;
    // End of variables declaration//GEN-END:variables
}
