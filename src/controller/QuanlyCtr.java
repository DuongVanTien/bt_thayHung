/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Hoadon;
import model.KhoangThoigian;
import model.ThongkeDoanhthu;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import views.QuanlyFrm;

/**
 *
 * @author tienduongvan
 */
public class QuanlyCtr {

    private Connection con = null;
    private Hoadon hoadon;
    private QuanlyFrm quanlyFrm;
    private KhoangThoigian khoangthoigian;
    private KiemtraDieukien kiemtraDieukien;
    private QuanlyTruyenCtr qlTruyenCtr = new QuanlyTruyenCtr();
    ArrayList<ThongkeDoanhthu> doanhthuThang = new ArrayList<ThongkeDoanhthu>();

    ResultSet rs = null;
    PreparedStatement ps = null;

    public QuanlyCtr() {
        quanlyFrm = new QuanlyFrm();
        kiemtraDieukien = new KiemtraDieukien();
        khoangthoigian = quanlyFrm.getKhoangThoigian();
        quanlyFrm.tblHienthiTKDTNgay(thongkeDoanhthuNgay(khoangthoigian));
        quanlyFrm.tblHienthiDanhsachTruyen(qlTruyenCtr.danhsachTruyen());
        quanlyFrm.btnThongkeNgaySubmitListener(new ThongkeNgayListener());
        quanlyFrm.btnInbaocaoThongkeNgaySubmitListener(new InbaocaoThongkeTheoNgayListener());
        quanlyFrm.btnPieChartThongkeNgaySubmitListener(new XemBieudoPieChartListener());
        quanlyFrm.btnBarChartThongkeNgaySubmitListener(new XemBieudoBarChartListener());

        quanlyFrm.setVisible(true);
    }

    class ThongkeNgayListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                khoangthoigian = quanlyFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (!kiemtraDieukien.testNgaythangnam(tungay) && !kiemtraDieukien.testNgaythangnam(denngay)) {
                    JOptionPane.showConfirmDialog(null, "Bạn điền thông tin từ ngày và đến ngày chưa đúng (yyyy-MM-dd)");
                } else if (!kiemtraDieukien.testNgaythangnam(tungay) && kiemtraDieukien.testNgaythangnam(denngay)) {
                    JOptionPane.showConfirmDialog(null, "Bạn điền thông tin từ ngày chưa đúng (yyyy-MM-dd)");
                } else if (kiemtraDieukien.testNgaythangnam(tungay) && !kiemtraDieukien.testNgaythangnam(denngay)) {
                    JOptionPane.showConfirmDialog(null, "Bạn điền thông tin đến ngày chưa đúng (yyyy-MM-dd)");
                } else if (!tungay.equalsIgnoreCase("") && tungay != null && tungay.isEmpty()
                        && !denngay.equalsIgnoreCase("") && denngay == null && denngay.isEmpty()) {
                    if (kiemtraDieukien.testTungayDenngay(tungay, denngay)) {
                        quanlyFrm.tblHienthiTKDTNgay(thongkeDoanhthuNgay(khoangthoigian));
                        quanlyFrm.showMessage("Bạn đang xem thống kê theo ngày");
                    }
                } else {
                    quanlyFrm.tblHienthiTKDTNgay(thongkeDoanhthuNgay(khoangthoigian));
                    quanlyFrm.showMessage("Bạn đang xem thống kê theo ngày");
                }

//                quanlyFrm.tblHienthiTKDTNgay(thongkeDoanhthuNgay(khoangthoigian));
//                quanlyFrm.showMessage("Bạn đang xem thống kê theo ngày");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class InbaocaoThongkeTheoNgayListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            khoangthoigian = quanlyFrm.getKhoangThoigian();
            ArrayList<ThongkeDoanhthu> listDatas = thongkeDoanhthuNgay(khoangthoigian);
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("BaocaoThongkeNgay" + new Date().toString() + ".pdf"));
                document.open();
                document.add(new Paragraph("Báo cáo doanh thu theo ngày", FontFactory.getFont(FontFactory.TIMES_ITALIC)));
                document.add(new Paragraph(new Date().toString()));
                document.add(new Paragraph("------------------------------------------------------------------------"));
                PdfPTable table = new PdfPTable(3);
                PdfPCell cell = new PdfPCell(new Paragraph("Title"));
                cell.setColspan(4);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.CYAN);
                table.addCell(cell);

                for (int i = 1; i < listDatas.size(); i++) {
                    table.addCell(i + "");
                    table.addCell(listDatas.get(i).getTenThongke());
                    table.addCell(listDatas.get(i).getDoanhthu() + "");
                }
                document.add(table);
                document.close();
                JOptionPane.showConfirmDialog(null, "Lưu báo cáo thành công");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            } finally {
                try {
                    rs.close();
                    ps.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    class XemBieudoPieChartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<ThongkeDoanhthu> listDataDoanhthuNgay = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = quanlyFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuNgay = thongkeDoanhthuNgay(new KhoangThoigian(tungay, denngay));
                System.out.println("listData :" + listDataDoanhthuNgay);
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int i = 0; i < listDataDoanhthuNgay.size(); i++) {
                    pieDataset.setValue(listDataDoanhthuNgay.get(i).getTenThongke(), listDataDoanhthuNgay.get(i).getDoanhthu());
                }
                JFreeChart chart = ChartFactory.createPieChart("Doanh thu ngày", pieDataset, true, true, true);
                PiePlot p = (PiePlot) chart.getPlot();
                ChartFrame frame = new ChartFrame("Pie Chart thống kê doanh thu theo ngày", chart);
                frame.setVisible(true);
                frame.setSize(800, 600);
                quanlyFrm.showMessage("Bạn đang xem biểu đồ Pie Chart thống kê doanh thu theo ngày");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class XemBieudoBarChartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<ThongkeDoanhthu> listDataDoanhthuNgay = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = quanlyFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuNgay = thongkeDoanhthuNgay(new KhoangThoigian(tungay, denngay));
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int i = 0; i < listDataDoanhthuNgay.size(); i++) {
                    String[] thang = listDataDoanhthuNgay.get(i).getTenThongke().split("/");
                    dataset.setValue(listDataDoanhthuNgay.get(i).getDoanhthu(), listDataDoanhthuNgay.get(i).getTenThongke(), "");
                }
                JFreeChart chart = ChartFactory.createBarChart("Doanh thu ngày", "Biểu đồ Bar Chart", "VND", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = (CategoryPlot) chart.getPlot();
                p.setRangeGridlinePaint(Color.BLACK);
                ChartFrame frame = new ChartFrame("Bar Chart thống kê doanh thu theo ngày", chart);
                frame.setVisible(true);
                frame.setSize(1300, 800);
                quanlyFrm.showMessage("Bạn đang xem biểu đồ Bar Chart thống kê doanh thu theo ngày");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<ThongkeDoanhthu> thongkeDoanhthuNgay(KhoangThoigian khoangthoigian) {
        System.out.println("thongkeDoanhthuNgay  ---- START");
        String tuNgay = khoangthoigian.getTungay();
        String denNgay = khoangthoigian.getDenngay();
        if (tuNgay == null || tuNgay.equalsIgnoreCase("")) {
            tuNgay = "2000-01-01";
        }
        if (denNgay == null || denNgay.equalsIgnoreCase("")) {
            denNgay = "2050-01-01";
        }
        System.out.println("tu ngay : " + tuNgay + " -- den ngay : " + denNgay);
        String sqlQuery = "SELECT  day(ngaytra) as ngay, month(ngaytra) as thang, year(ngaytra) as nam, SUM(tongtien) as doanhthu "
                + "FROM tblHoadon "
                + "where ngaytra >=\'" + tuNgay + "\' and ngaytra <= \'" + denNgay + "\'"
                + "group by year(ngaytra), month(ngaytra), day(ngaytra) "
                + "order by  year(ngaytra) desc, month(ngaytra) desc, day(ngaytra) desc ";

        ArrayList<ThongkeDoanhthu> listDataDoanhthuNgay = new ArrayList<ThongkeDoanhthu>();
        ThongkeDoanhthu tkdt = null;
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ngay = rs.getString("ngay");
                String thang = rs.getString("thang");
                String nam = rs.getString("nam");
                String tenThongke = ngay + "/" + thang + "/" + nam;
                float doanhthu = rs.getFloat("doanhthu");
                tkdt = new ThongkeDoanhthu(tenThongke, doanhthu);
                listDataDoanhthuNgay.add(tkdt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(QuanlyCtr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("listDataDoanhthuNgay : " + listDataDoanhthuNgay.size());
        return listDataDoanhthuNgay;
    }

}
