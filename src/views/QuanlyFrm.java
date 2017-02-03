package views;

import controller.ThongkeDoanhthuNamCtr;
import controller.ThongkeDoanhthuQuyCtr;
import controller.ThongkeDoanhthuThangCtr;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import model.KhoangThoigian;
import model.ThongkeDoanhthu;
import model.Truyen;

public class QuanlyFrm extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public QuanlyFrm() {
        initComponents();
        CurrentDate();
    }

    public void CurrentDate() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        jmnNgaythang.setText("Current date : " + day + "/" + (month + 1) + "/" + year);
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        jmnThoigian.setText("Current time is  " + hour + " : " + minute + " : " + second);
    }

    public void btnDangxuatActionPerformed() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void tblHienthiTKDTNgay(ArrayList<ThongkeDoanhthu> datas) {
        int rowCount = tblThongkeDoanhthuNgay.getModel().getRowCount();
        DefaultTableModel model = (DefaultTableModel) tblThongkeDoanhthuNgay.getModel();
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

    public void tblHienthiDanhsachTruyen(ArrayList<Truyen> danhsachTruyen) {
        DefaultTableModel model = (DefaultTableModel) tblTruyen.getModel();
        Object[] row = new Object[8];
        for (int i = 1; i < danhsachTruyen.size(); i++) {
            row[0] = i;
            row[1] = danhsachTruyen.get(i).getMaTruyen();
            row[2] = danhsachTruyen.get(i).getTenTruyen();
            row[3] = danhsachTruyen.get(i).getTacgia().getTenTacgia();
            row[4] = danhsachTruyen.get(i).getNhaxuatban().getTenNXB();
            row[5] = danhsachTruyen.get(i).getTheloai().getTenTheloai();
            row[6] = danhsachTruyen.get(i).getNamxuatban();
            row[7] = danhsachTruyen.get(i).getGiathue();
            model.addRow(row);
        }
    }

    public void btnThongkeNgaySubmitListener(ActionListener log) {
        btnThongkeNgay.addActionListener(log);
    }
    
    public void btnInbaocaoThongkeNgaySubmitListener(ActionListener log) {
        btnInbaocaoThongkeNgay.addActionListener(log);
    }
    
    public void btnPieChartThongkeNgaySubmitListener(ActionListener log) {
        btnPieChartThongkeNgay.addActionListener(log);
    }
    
    public void btnBarChartThongkeNgaySubmitListener(ActionListener log) {
        btnBarChartThongkeNgay.addActionListener(log);
    }
    
    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    
    public KhoangThoigian getKhoangThoigian() {
        String tungay = tfTungay.getText().toString();
        String denngay = tfDenngay.getText().toString();
        return (new KhoangThoigian(tungay, denngay));
    }

    public void tblTungayDenngayThongkeNgay(ArrayList<ThongkeDoanhthu> listDatas) {
        DefaultTableModel model = (DefaultTableModel) tblThongkeDoanhthuNgay.getModel();
        Object[] row = new Object[3];
        for (int i = 1; i < listDatas.size(); i++) {
            row[0] = i;
            row[1] = listDatas.get(i).getTenThongke();
            row[2] = listDatas.get(i).getDoanhthu();
            model.addRow(row);
        }
    }

    public void btnTungayDenngayThongkeNgaySubmitListener(ActionListener log) {
        btnThongkeNgay.addActionListener(log);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTruyen = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblMatruyen = new javax.swing.JLabel();
        lblTentruyen = new javax.swing.JLabel();
        lblTacgia = new javax.swing.JLabel();
        lblNhaxuatban = new javax.swing.JLabel();
        tfMatruyen = new javax.swing.JTextField();
        tfTentruyen = new javax.swing.JTextField();
        lblTheloai = new javax.swing.JLabel();
        lblNamxuatban = new javax.swing.JLabel();
        lblGiathue = new javax.swing.JLabel();
        tfNamxuatban = new javax.swing.JTextField();
        tfGiathue = new javax.swing.JTextField();
        cbbTacgia = new javax.swing.JComboBox<>();
        cbbNhaxuatban = new javax.swing.JComboBox<>();
        cbbTheloai = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        tfTimkiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnThemTruyen = new javax.swing.JButton();
        btnSuaTruyen = new javax.swing.JButton();
        btnXoaTruyen = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongkeDoanhthuNgay = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        btnBarChartThongkeNgay = new javax.swing.JButton();
        btnInbaocaoThongkeNgay = new javax.swing.JButton();
        btnPieChartThongkeNgay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnThongkeNgay = new javax.swing.JButton();
        btnLammoiThongkeNgay = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        tfTungay = new javax.swing.JTextField();
        tfDenngay = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnTKDTThang = new javax.swing.JButton();
        btnTKDTNam = new javax.swing.JButton();
        btnTKDTQuy = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmnDangxuat = new javax.swing.JMenuItem();
        jmnIn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jmnThongtinCuahang = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnTrogiup = new javax.swing.JMenuItem();
        jmnNgaythang = new javax.swing.JMenu();
        jmnThoigian = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin Page");

        tblTruyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã truyện", "Tên truyện", "Tác giả", "Nhà xuất bản", "Thể loại", "Năm xuất bản", "Giá thuê"
            }
        ));
        tblTruyen.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tblTruyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTruyenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTruyen);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin truyện", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 51, 204))); // NOI18N

        lblMatruyen.setText("Mã truyện");

        lblTentruyen.setText("Tên truyện");

        lblTacgia.setText("Tác giả");

        lblNhaxuatban.setText("Nhà xuất bản");

        lblTheloai.setText("Thể loại");

        lblNamxuatban.setText("Năm xuất bản");

        lblGiathue.setText("Giá thuê");

        cbbTacgia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Akira Toriyama", "Dale Carnegie", "Nguyễn Hùng Lân", "Fujiko Fujio", "Sơn Tùng", "Tony" }));

        cbbNhaxuatban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kim Đồng", "Báo tuổi trẻ", "Giáo dục đào tạo", "Thiếu niên tiền phong", "Hoa học trò" }));

        cbbTheloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Văn học xã hội", "Truyện tranh kiếm hiệp", "Giáo dục con người" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTheloai)
                    .addComponent(lblMatruyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTentruyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMatruyen, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbbTacgia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfTentruyen, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbbTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGiathue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamxuatban)
                            .addComponent(lblNhaxuatban))
                        .addGap(6, 6, 6)))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbbNhaxuatban, 0, 176, Short.MAX_VALUE)
                    .addComponent(tfNamxuatban)
                    .addComponent(tfGiathue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatruyen)
                    .addComponent(tfMatruyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTentruyen)
                    .addComponent(tfTentruyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNhaxuatban)
                    .addComponent(cbbNhaxuatban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTacgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTacgia)
                    .addComponent(lblNamxuatban)
                    .addComponent(tfNamxuatban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGiathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTheloai)
                    .addComponent(lblGiathue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(184, 26, 26))); // NOI18N

        tfTimkiem.setText("tên truyện");
        tfTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimkiemActionPerformed(evt);
            }
        });
        tfTimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimkiemKeyReleased(evt);
            }
        });

        btnTimkiem.setText("Tìm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 15), new java.awt.Color(0, 0, 153))); // NOI18N

        btnThemTruyen.setText("Thêm");
        btnThemTruyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTruyenActionPerformed(evt);
            }
        });

        btnSuaTruyen.setText("Sửa");
        btnSuaTruyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTruyenActionPerformed(evt);
            }
        });

        btnXoaTruyen.setText("Xóa");
        btnXoaTruyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTruyenActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaTruyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemTruyen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaTruyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemTruyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaTruyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaTruyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTimkiem, tfTimkiem});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý Truyện", jPanel4);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Thống kê theo ngày"));

        tblThongkeDoanhthuNgay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ngày", "Doanh thu"
            }
        ));
        tblThongkeDoanhthuNgay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(tblThongkeDoanhthuNgay);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnBarChartThongkeNgay.setText("Xem biểu đồ BarChart");
        btnBarChartThongkeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarChartThongkeNgayActionPerformed(evt);
            }
        });

        btnInbaocaoThongkeNgay.setText("In báo cáo");
        btnInbaocaoThongkeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInbaocaoThongkeNgayActionPerformed(evt);
            }
        });

        btnPieChartThongkeNgay.setText("Xem biểu đồ PieChart");
        btnPieChartThongkeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPieChartThongkeNgayActionPerformed(evt);
            }
        });

        jLabel1.setText("Từ ngày");

        jLabel2.setText("Đến ngày");

        btnThongkeNgay.setText("Thống kê");
        btnThongkeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongkeNgayActionPerformed(evt);
            }
        });

        btnLammoiThongkeNgay.setText("Làm mới");
        btnLammoiThongkeNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiThongkeNgayActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTungay)
                            .addComponent(tfDenngay)
                            .addComponent(btnThongkeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLammoiThongkeNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBarChartThongkeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .addComponent(btnInbaocaoThongkeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPieChartThongkeNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongkeNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLammoiThongkeNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPieChartThongkeNgay)
                .addGap(18, 18, 18)
                .addComponent(btnBarChartThongkeNgay)
                .addGap(18, 18, 18)
                .addComponent(btnInbaocaoThongkeNgay)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 326, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng thống kê mở rộng"));

        btnTKDTThang.setText("Thống kê theo tháng");
        btnTKDTThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKDTThangActionPerformed(evt);
            }
        });

        btnTKDTNam.setText("Thống kê theo năm");
        btnTKDTNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKDTNamActionPerformed(evt);
            }
        });

        btnTKDTQuy.setText("Thống kê theo quý");
        btnTKDTQuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKDTQuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnTKDTThang, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnTKDTQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTKDTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTKDTThang)
                    .addComponent(btnTKDTQuy)
                    .addComponent(btnTKDTNam))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Thống kê doanh thu", jPanel5);

        jMenu1.setText("File");

        jmnDangxuat.setText("Đăng xuất");
        jmnDangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnDangxuatActionPerformed(evt);
            }
        });
        jMenu1.add(jmnDangxuat);

        jmnIn.setText("In");
        jMenu1.add(jmnIn);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Help");

        jmnThongtinCuahang.setText("Thông tin cửa hàng");
        jmnThongtinCuahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnThongtinCuahangActionPerformed(evt);
            }
        });
        jMenu4.add(jmnThongtinCuahang);
        jMenu4.add(jSeparator1);

        jmnTrogiup.setText("Trợ giúp");
        jmnTrogiup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnTrogiupActionPerformed(evt);
            }
        });
        jMenu4.add(jmnTrogiup);

        jMenuBar1.add(jMenu4);

        jmnNgaythang.setForeground(new java.awt.Color(204, 0, 153));
        jmnNgaythang.setText("Ngày : ");
        jmnNgaythang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.add(jmnNgaythang);

        jmnThoigian.setForeground(new java.awt.Color(204, 0, 153));
        jmnThoigian.setText("Thời gian : ");
        jmnThoigian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jmnThoigian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jmnThoigian.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuBar1.add(jmnThoigian);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnThemTruyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTruyenActionPerformed
    }//GEN-LAST:event_btnThemTruyenActionPerformed
    private void btnSuaTruyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTruyenActionPerformed
    }//GEN-LAST:event_btnSuaTruyenActionPerformed
    private void btnXoaTruyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTruyenActionPerformed
    }//GEN-LAST:event_btnXoaTruyenActionPerformed
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    }//GEN-LAST:event_btnClearActionPerformed
    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
    }//GEN-LAST:event_btnTimkiemActionPerformed
    private void tfTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimkiemActionPerformed
    }//GEN-LAST:event_tfTimkiemActionPerformed
    private void tfTimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimkiemKeyReleased
    }//GEN-LAST:event_tfTimkiemKeyReleased

    private void tblTruyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTruyenMouseClicked
        int row = tblTruyen.getSelectedRow();
        tfMatruyen.setText(tblTruyen.getModel().getValueAt(row, 1).toString());
        tfTentruyen.setText(tblTruyen.getModel().getValueAt(row, 2).toString());
        tfNamxuatban.setText(tblTruyen.getModel().getValueAt(row, 6).toString());
        tfGiathue.setText(tblTruyen.getModel().getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblTruyenMouseClicked

    private void jmnThongtinCuahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnThongtinCuahangActionPerformed
        ThongtinCuahangFrm ttch = new ThongtinCuahangFrm();
        ttch.setVisible(true);
    }//GEN-LAST:event_jmnThongtinCuahangActionPerformed

    private void jmnTrogiupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnTrogiupActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "abc.pdf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jmnTrogiupActionPerformed

    private void jmnDangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnDangxuatActionPerformed
        try {
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
        }
        DangnhapFrm s = new DangnhapFrm();
        s.setVisible(true);
        btnDangxuatActionPerformed();
    }//GEN-LAST:event_jmnDangxuatActionPerformed

    private void btnPieChartThongkeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPieChartThongkeNgayActionPerformed
    }//GEN-LAST:event_btnPieChartThongkeNgayActionPerformed

    private void btnBarChartThongkeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarChartThongkeNgayActionPerformed
    }//GEN-LAST:event_btnBarChartThongkeNgayActionPerformed

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void btnTKDTThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKDTThangActionPerformed
        ThongkeDoanhthuThangCtr tkdtThangCtr  = new ThongkeDoanhthuThangCtr();
//        close();/
    }//GEN-LAST:event_btnTKDTThangActionPerformed

    private void btnTKDTQuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKDTQuyActionPerformed
        ThongkeDoanhthuQuyCtr tkdtThangCtr  = new ThongkeDoanhthuQuyCtr();
//        close();
    }//GEN-LAST:event_btnTKDTQuyActionPerformed

    private void btnTKDTNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKDTNamActionPerformed
        ThongkeDoanhthuNamCtr tkdtThangCtr  = new ThongkeDoanhthuNamCtr();
//        close();
    }//GEN-LAST:event_btnTKDTNamActionPerformed

    private void btnThongkeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongkeNgayActionPerformed
    }//GEN-LAST:event_btnThongkeNgayActionPerformed

    private void btnInbaocaoThongkeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInbaocaoThongkeNgayActionPerformed
    }//GEN-LAST:event_btnInbaocaoThongkeNgayActionPerformed

    private void btnLammoiThongkeNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiThongkeNgayActionPerformed
        tfTungay.setText("");
        tfDenngay.setText("");
    }//GEN-LAST:event_btnLammoiThongkeNgayActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanlyFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanlyFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanlyFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanlyFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanlyFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarChartThongkeNgay;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnInbaocaoThongkeNgay;
    private javax.swing.JButton btnLammoiThongkeNgay;
    private javax.swing.JButton btnPieChartThongkeNgay;
    private javax.swing.JButton btnSuaTruyen;
    private javax.swing.JButton btnTKDTNam;
    private javax.swing.JButton btnTKDTQuy;
    private javax.swing.JButton btnTKDTThang;
    private javax.swing.JButton btnThemTruyen;
    private javax.swing.JButton btnThongkeNgay;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnXoaTruyen;
    private javax.swing.JComboBox<String> cbbNhaxuatban;
    private javax.swing.JComboBox<String> cbbTacgia;
    private javax.swing.JComboBox<String> cbbTheloai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem jmnDangxuat;
    private javax.swing.JMenuItem jmnIn;
    private javax.swing.JMenu jmnNgaythang;
    private javax.swing.JMenu jmnThoigian;
    private javax.swing.JMenuItem jmnThongtinCuahang;
    private javax.swing.JMenuItem jmnTrogiup;
    private javax.swing.JLabel lblGiathue;
    private javax.swing.JLabel lblMatruyen;
    private javax.swing.JLabel lblNamxuatban;
    private javax.swing.JLabel lblNhaxuatban;
    private javax.swing.JLabel lblTacgia;
    private javax.swing.JLabel lblTentruyen;
    private javax.swing.JLabel lblTheloai;
    private javax.swing.JTable tblThongkeDoanhthuNgay;
    private javax.swing.JTable tblTruyen;
    private javax.swing.JTextField tfDenngay;
    private javax.swing.JTextField tfGiathue;
    private javax.swing.JTextField tfMatruyen;
    private javax.swing.JTextField tfNamxuatban;
    private javax.swing.JTextField tfTentruyen;
    private javax.swing.JTextField tfTimkiem;
    private javax.swing.JTextField tfTungay;
    // End of variables declaration//GEN-END:variables
}
