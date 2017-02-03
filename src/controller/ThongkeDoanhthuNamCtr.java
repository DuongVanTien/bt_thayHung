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
import views.ThongkeDoanhthuNamFrm;

/**
 *
 * @author tienduongvan
 */
public class ThongkeDoanhthuNamCtr {

    private Connection con = null;
    private Hoadon hoadon;
    private ThongkeDoanhthuNamFrm tkdtNamFrm;
    private KhoangThoigian khoangthoigian;
    private KiemtraDieukien kiemtraDieukien;
    ArrayList<ThongkeDoanhthu> doanhthuNam = new ArrayList<ThongkeDoanhthu>();

    ResultSet rs = null;
    PreparedStatement ps = null;

    public ThongkeDoanhthuNamCtr() {
        tkdtNamFrm = new ThongkeDoanhthuNamFrm();
        khoangthoigian = tkdtNamFrm.getKhoangThoigian();
        kiemtraDieukien = new KiemtraDieukien();
        tkdtNamFrm.tblHienthiTKDTNam(thongkeDoanhthuNam(khoangthoigian));
        tkdtNamFrm.btnThongkeNamSubmitListener(new ThongkeNamListener());
        tkdtNamFrm.btnInbaocaoThongkeNamSubmitListener(new InbaocaoThongkeTheoNamListener());
        tkdtNamFrm.btnPieChartThongkeNamSubmitListener(new XemBieudoPieChartListener());
        tkdtNamFrm.btnBarChartThongkeNamSubmitListener(new XemBieudoBarChartListener());

        tkdtNamFrm.setVisible(true);
    }

    class ThongkeNamListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                khoangthoigian = tkdtNamFrm.getKhoangThoigian();
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
                        tkdtNamFrm.tblHienthiTKDTNam(thongkeDoanhthuNam(khoangthoigian));
                        tkdtNamFrm.showMessage("Bạn đang xem thống kê theo năm");
                    }
                } else {
                    tkdtNamFrm.tblHienthiTKDTNam(thongkeDoanhthuNam(khoangthoigian));
                    tkdtNamFrm.showMessage("Bạn đang xem thống kê theo năm");
                }
//                tkdtNamFrm.tblHienthiTKDTNam(thongkeDoanhthuNam(khoangthoigian));
//                tkdtNamFrm.showMessage("Bạn đang xem thống kê theo năm");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class InbaocaoThongkeTheoNamListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            khoangthoigian = tkdtNamFrm.getKhoangThoigian();
            ArrayList<ThongkeDoanhthu> listDatas = thongkeDoanhthuNam(khoangthoigian);
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("BaocaoThongkeNam - " + new Date().toString() + ".pdf"));
                document.open();
                document.add(new Paragraph("Báo cáo doanh thu theo năm", FontFactory.getFont(FontFactory.TIMES_ITALIC)));
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
                ArrayList<ThongkeDoanhthu> listDataDoanhthuNam = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = tkdtNamFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuNam = thongkeDoanhthuNam(new KhoangThoigian(tungay, denngay));
                System.out.println("listData :" + listDataDoanhthuNam);
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int i = 0; i < listDataDoanhthuNam.size(); i++) {
                    pieDataset.setValue(listDataDoanhthuNam.get(i).getTenThongke(), listDataDoanhthuNam.get(i).getDoanhthu());
                }
                JFreeChart chart = ChartFactory.createPieChart("Doanh thu năm", pieDataset, true, true, true);
                PiePlot p = (PiePlot) chart.getPlot();
                ChartFrame frame = new ChartFrame("Pie Chart thống kê doanh thu theo năm", chart);
                frame.setVisible(true);
                frame.setSize(800, 600);
                tkdtNamFrm.showMessage("Bạn đang xem biểu đồ Pie Chart thống kê doanh thu theo năm");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class XemBieudoBarChartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<ThongkeDoanhthu> listDataDoanhthuNam = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = tkdtNamFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuNam = thongkeDoanhthuNam(new KhoangThoigian(tungay, denngay));
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int i = 0; i < listDataDoanhthuNam.size(); i++) {
                    String[] thang = listDataDoanhthuNam.get(i).getTenThongke().split("/");
                    dataset.setValue(listDataDoanhthuNam.get(i).getDoanhthu(), listDataDoanhthuNam.get(i).getTenThongke(), "");
                }
                JFreeChart chart = ChartFactory.createBarChart("Doanh thu năm", "Biểu đồ Bar Chart", "VND", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = (CategoryPlot) chart.getPlot();
                p.setRangeGridlinePaint(Color.BLACK);
                ChartFrame frame = new ChartFrame("Bar Chart thống kê doanh thu theo năm", chart);
                frame.setVisible(true);
                frame.setSize(1300, 800);
                tkdtNamFrm.showMessage("Bạn đang xem biểu đồ Bar Chart thống kê doanh thu theo năm");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<ThongkeDoanhthu> thongkeDoanhthuNam(KhoangThoigian khoangthoigian) {
//        System.out.println("thongkeDoanhthuNam  ---- START");
        String sqlQuery = "SELECT  year(ngaytra) as nam, SUM(tongtien) as doanhthu "
                + "FROM tblHoadon "
                + "group by year(ngaytra) "
                + "order by  year(ngaytra) desc ";

        ArrayList<ThongkeDoanhthu> listDataDoanhthuNam = new ArrayList<ThongkeDoanhthu>();
        ThongkeDoanhthu tkdt = null;
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nam = rs.getString("nam");
                String tenThongke = nam;
                float doanhthu = rs.getFloat("doanhthu");
                tkdt = new ThongkeDoanhthu(tenThongke, doanhthu);
                listDataDoanhthuNam.add(tkdt);
            }
        } catch (Exception e) {
            Logger.getLogger("--- method listDataThongkeDoanhthuNam exception :");
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThongkeDoanhthuNamCtr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listDataDoanhthuNam;
    }
}
