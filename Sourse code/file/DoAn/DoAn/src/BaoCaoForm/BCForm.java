/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaoCaoForm;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.math.BigDecimal;
import javax.swing.JPanel;

public class BCForm extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form BaoCaoForm
     */
    public BCForm() {
        initComponents();
        KetNoiCSDL();
    }

    public JPanel getJPN(){
        return jpnBC;
    }
    public void KetNoiCSDL(){ 
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("Ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");
        
        } catch (SQLException ex) {
            Logger.getLogger(BCForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    public static void disableAccessWarnings() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object unsafe = field.get(null);

            Method putObjectVolatile = unsafeClass.getDeclaredMethod("putObjectVolatile", Object.class, long.class, Object.class);
            Method staticFieldOffset = unsafeClass.getDeclaredMethod("staticFieldOffset", Field.class);

            Class loggerClass = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field loggerField = loggerClass.getDeclaredField("logger");
            Long offset = (Long) staticFieldOffset.invoke(unsafe, loggerField);
            putObjectVolatile.invoke(unsafe, loggerClass, offset, null);
        } catch (Exception ignored) {
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

        jpnBC = new javax.swing.JPanel();
        nam = new javax.swing.JButton();
        thang = new javax.swing.JButton();
        topSach = new javax.swing.JButton();
        TopKH = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnBC.setLayout(new java.awt.GridLayout(4, 1, 2, 2));

        nam.setBackground(new java.awt.Color(255, 204, 153));
        nam.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        nam.setText("Doanh thu từng năm");
        nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namActionPerformed(evt);
            }
        });
        jpnBC.add(nam);

        thang.setBackground(new java.awt.Color(255, 204, 102));
        thang.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        thang.setText("Doanh thu theo từng tháng của năm");
        thang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thangActionPerformed(evt);
            }
        });
        jpnBC.add(thang);

        topSach.setBackground(new java.awt.Color(249, 163, 76));
        topSach.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        topSach.setText("Top sách bán chạy theo năm");
        topSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topSachActionPerformed(evt);
            }
        });
        jpnBC.add(topSach);

        TopKH.setBackground(new java.awt.Color(255, 153, 0));
        TopKH.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        TopKH.setText("Top khách hàng có hóa đơn cao theo năm");
        TopKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopKHActionPerformed(evt);
            }
        });
        jpnBC.add(TopKH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jpnBC, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jpnBC, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namActionPerformed
        disableAccessWarnings();
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");  

        JasperDesign jd  = JRXmlLoader.load("C:/file/file report/DoanhSoNam.jrxml");
        JasperReport jr = JasperCompileManager.compileReport("C:/file/file report/DoanhSoNam.jrxml");
        JasperPrint  jp = JasperFillManager.fillReport(jr, new HashMap(),con);
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);
        
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_namActionPerformed

    private void thangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thangActionPerformed
        // TODO add your handling code here:
        disableAccessWarnings();
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");  
        
        String i = JOptionPane.showInputDialog("Nhập năm cần thống kê: "); 
        BigDecimal nam= new BigDecimal(i);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Năm",nam);
        
        JasperDesign jd  = JRXmlLoader.load("C:/file/file report/DoanhSoThang.jrxml");
        JasperReport jr = JasperCompileManager.compileReport("C:/file/file report/DoanhSoThang.jrxml");
        JasperPrint  jp = JasperFillManager.fillReport(jr,parameters,con);
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);
        
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_thangActionPerformed

    private void topSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topSachActionPerformed
        disableAccessWarnings();
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");  

        String i = JOptionPane.showInputDialog("Nhập năm cần thống kê: "); 
        BigDecimal nam= new BigDecimal(i);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Năm",nam);
        
        JasperDesign jd  = JRXmlLoader.load("C:/file/file report/TopSach.jrxml");
        JasperReport jr = JasperCompileManager.compileReport("C:/file/file report/TopSach.jrxml");
        JasperPrint  jp = JasperFillManager.fillReport(jr,parameters,con);
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);
        
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_topSachActionPerformed

    private void TopKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopKHActionPerformed
        disableAccessWarnings();
        
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DoAn", "doan");  

        String i = JOptionPane.showInputDialog("Nhập năm cần thống kê: "); 
        BigDecimal nam= new BigDecimal(i);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Năm",nam);
        
        JasperDesign jd  = JRXmlLoader.load("C:/file/file report/TopKH.jrxml");
        JasperReport jr = JasperCompileManager.compileReport("C:/file/file report/TopKH.jrxml");
        JasperPrint  jp = JasperFillManager.fillReport(jr,parameters,con);
        JasperViewer jv = new JasperViewer(jp,false);
        jv.setVisible(true);
        }

        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
         }
    }//GEN-LAST:event_TopKHActionPerformed

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
            java.util.logging.Logger.getLogger(BCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BCForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BCForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TopKH;
    private javax.swing.JPanel jpnBC;
    private javax.swing.JButton nam;
    private javax.swing.JButton thang;
    private javax.swing.JButton topSach;
    // End of variables declaration//GEN-END:variables
}
