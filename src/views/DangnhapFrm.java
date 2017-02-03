package views;

import controller.DBConnection;
import controller.QuanlyCtr;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

public class DangnhapFrm extends javax.swing.JFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public DangnhapFrm() {
        initComponents();
        CurrentDate();
    }

    public void CurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        lblDate.setText("Hệ thống: " + day + "/" + (month + 1) + "/" + year);
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTentaikhoan = new javax.swing.JLabel();
        lblMatkhau = new javax.swing.JLabel();
        tfTentaikhoan = new javax.swing.JTextField();
        lblChucvu = new javax.swing.JLabel();
        cbbChucvu = new javax.swing.JComboBox();
        btnDangnhap = new javax.swing.JButton();
        tfMatkhau = new javax.swing.JPasswordField();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login Page  - ProMA");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 255, 204));
        setForeground(new java.awt.Color(204, 255, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 10), new java.awt.Color(0, 51, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));

        lblTentaikhoan.setText("Tên tài khoản");

        lblMatkhau.setText("Mật khẩu");

        lblChucvu.setText("Chức vụ");

        cbbChucvu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chức vụ", "Quản lý", "Nhân viên" }));
        cbbChucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucvuActionPerformed(evt);
            }
        });

        btnDangnhap.setText("Đăng nhập");
        btnDangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangnhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTentaikhoan)
                    .addComponent(lblMatkhau)
                    .addComponent(lblChucvu))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTentaikhoan)
                    .addComponent(cbbChucvu, 0, 159, Short.MAX_VALUE)
                    .addComponent(tfMatkhau)
                    .addComponent(btnDangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTentaikhoan)
                    .addComponent(tfTentaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatkhau)
                    .addComponent(tfMatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChucvu)
                    .addComponent(cbbChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDangnhap)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDate)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        con = DBConnection.getConnect();
    }//GEN-LAST:event_formWindowOpened

    private void btnDangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangnhapActionPerformed

        String sql = "select * from tblNhanvien where tenTaikhoan =? and matkhau =? and chucvu=?";
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            ps.setString(1, tfTentaikhoan.getText());
            ps.setString(2, tfMatkhau.getText());
            if (tfTentaikhoan.getText().equals("") || tfTentaikhoan.getText() == null && tfMatkhau.getText().equals("")
                    || tfMatkhau.getText() == null) {
                JOptionPane.showMessageDialog(null, "Tên tài khoản và mật khẩu không đưược bỏ trống");
            } else {
                String chucvu = "";
                if (cbbChucvu.getSelectedItem().toString().equalsIgnoreCase("Quản lý")) {
                    chucvu = "QL";
                } else if (cbbChucvu.getSelectedItem().toString().equalsIgnoreCase("Nhân viên")) {
                    chucvu = "NV";
                }
                ps.setString(3, chucvu);
                rs = ps.executeQuery();

                int count = 0;
                while (rs.next()) {
                    count = count + 1;
                }

                if (chucvu == "QL") {
                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                        QuanlyCtr quanlyCtr = new QuanlyCtr();
//                    DangnhapTest dangnhapTest = new DangnhapTest();
//                    dangnhapTest.testDangnhap(tfTentaikhoan.getText(), tfMatkhau.getText());
                        close();
                    } else if (count > 1) {
                        JOptionPane.showMessageDialog(null, "Tài khoản bị trùng lặp");
                    } else {
                        System.out.println("chuc vu 1: " + chucvu);
                        JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                    }
                } else if (chucvu == "NV") {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
//                QuanlyCtr quanlyCtr = new QuanlyCtr();
                    close();

                } else {
                    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDangnhapActionPerformed

    private void cbbChucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucvuActionPerformed
    }//GEN-LAST:event_cbbChucvuActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DangnhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangnhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangnhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangnhapFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DangnhapFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangnhap;
    private javax.swing.JComboBox cbbChucvu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblChucvu;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMatkhau;
    private javax.swing.JLabel lblTentaikhoan;
    private javax.swing.JPasswordField tfMatkhau;
    private javax.swing.JTextField tfTentaikhoan;
    // End of variables declaration//GEN-END:variables
}
