package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhoangThoigian;
import model.ThongkeDoanhthu;

/**
 *
 * @author tienduongvan
 */
public class ThongkeDoanhthuThangFrm extends javax.swing.JFrame {

    public ThongkeDoanhthuThangFrm() {
        initComponents();
    }
    
    public void tblHienthiTKDTThang(ArrayList<ThongkeDoanhthu> datas) {
        int rowCount = tblThongkeDoanhthuThang.getModel().getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblThongkeDoanhthuThang.getModel();
        if (rowCount > 0) {
            for (int i = 0; i < rowCount; i++) {
                model.removeRow(0);
            }
        }
        Object[] row = new Object[3];
        for (int i = 1; i < datas.size(); i++) {
            row[0] = i;
            row[1] = datas.get(i).getTenThongke();
            row[2] = datas.get(i).getDoanhthu();
            model.addRow(row);
        }
    }

    public void btnThongkeThangSubmitListener(ActionListener log) {
        btnThongkeThang.addActionListener(log);
    }
    
    public void btnInbaocaoThongkeThangSubmitListener(ActionListener log) {
        btnInbaocaoThongkeThang.addActionListener(log);
    }
    
    public void btnPieChartThongkeThangSubmitListener(ActionListener log) {
        btnPieChartThongkeThang.addActionListener(log);
    }
    
    public void btnBarChartThongkeThangSubmitListener(ActionListener log) {
        btnBarChartThongkeThang.addActionListener(log);
    }
    
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public KhoangThoigian getKhoangThoigian() {
        String tungay = tfTungay.getText().toString();
        String denngay = tfDenngay.getText().toString();
        return (new KhoangThoigian(tungay, denngay));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongkeDoanhthuThang = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnBarChartThongkeThang = new javax.swing.JButton();
        btnInbaocaoThongkeThang = new javax.swing.JButton();
        btnPieChartThongkeThang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnThongkeThang = new javax.swing.JButton();
        btnLammoiThongkeThang = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfTungay = new javax.swing.JTextField();
        tfDenngay = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê doanh thu theo tháng"));

        tblThongkeDoanhthuThang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "          STT", "          Tháng", "        Doanh thu"
            }
        ));
        tblThongkeDoanhthuThang.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(tblThongkeDoanhthuThang);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBarChartThongkeThang.setText("Xem biểu đồ BarChart");
        btnBarChartThongkeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarChartThongkeThangActionPerformed(evt);
            }
        });

        btnInbaocaoThongkeThang.setText("In báo cáo");

        btnPieChartThongkeThang.setText("Xem biểu đồ PieChart");
        btnPieChartThongkeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPieChartThongkeThangActionPerformed(evt);
            }
        });

        jLabel1.setText("Từ ngày");

        jLabel2.setText("Đến ngày");

        btnThongkeThang.setText("Thống kê");
        btnThongkeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeThangActionPerformed(evt);
            }
        });

        btnLammoiThongkeThang.setText("Làm mới");
        btnLammoiThongkeThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiThongkeThangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfDenngay)
                                .addComponent(btnThongkeThang, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                .addComponent(btnLammoiThongkeThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfTungay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInbaocaoThongkeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBarChartThongkeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPieChartThongkeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThongkeThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLammoiThongkeThang)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPieChartThongkeThang)
                .addGap(32, 32, 32)
                .addComponent(btnBarChartThongkeThang)
                .addGap(30, 30, 30)
                .addComponent(btnInbaocaoThongkeThang)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBarChartThongkeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarChartThongkeThangActionPerformed
    }//GEN-LAST:event_btnBarChartThongkeThangActionPerformed

    private void btnPieChartThongkeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPieChartThongkeThangActionPerformed
    }//GEN-LAST:event_btnPieChartThongkeThangActionPerformed

    private void btnThongkeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeThangActionPerformed
    }//GEN-LAST:event_btnThongkeThangActionPerformed

    private void btnLammoiThongkeThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiThongkeThangActionPerformed
        tfTungay.setText("");
        tfDenngay.setText("");
    }//GEN-LAST:event_btnLammoiThongkeThangActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongkeDoanhthuThangFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongkeDoanhthuThangFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongkeDoanhthuThangFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongkeDoanhthuThangFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongkeDoanhthuThangFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarChartThongkeThang;
    private javax.swing.JButton btnInbaocaoThongkeThang;
    private javax.swing.JButton btnLammoiThongkeThang;
    private javax.swing.JButton btnPieChartThongkeThang;
    private javax.swing.JButton btnThongkeThang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblThongkeDoanhthuThang;
    private javax.swing.JTextField tfDenngay;
    private javax.swing.JTextField tfTungay;
    // End of variables declaration//GEN-END:variables
}
