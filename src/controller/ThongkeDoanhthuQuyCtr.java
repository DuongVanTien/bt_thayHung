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
import views.ThongkeDoanhthuQuyFrm;

/**
 *
 * @author tienduongvan
 */
public class ThongkeDoanhthuQuyCtr {
    
    private Connection con = null;
    private ThongkeDoanhthuQuyFrm tkdtQuyFrm;
    private KhoangThoigian khoangthoigian;
    private KiemtraDieukien kiemtraDieukien;
    ArrayList<ThongkeDoanhthu> doanhthuQuy = new ArrayList<ThongkeDoanhthu>();

    ResultSet rs = null;
    PreparedStatement ps = null;

    public ThongkeDoanhthuQuyCtr() {
        tkdtQuyFrm = new ThongkeDoanhthuQuyFrm();
        khoangthoigian = tkdtQuyFrm.getKhoangThoigian();
        kiemtraDieukien = new KiemtraDieukien();
        tkdtQuyFrm.tblHienthiTKDTQuy(thongkeDoanhthuQuy(khoangthoigian));
        tkdtQuyFrm.btnThongkeQuySubmitListener(new ThongkeDoanhthuQuyCtr.ThongkeQuyListener());
        tkdtQuyFrm.btnInbaocaoThongkeQuySubmitListener(new InbaocaoThongkeTheoQuyListener());
        tkdtQuyFrm.btnPieChartThongkeQuySubmitListener(new XemBieudoPieChartListener());
        tkdtQuyFrm.btnBarChartThongkeQuySubmitListener(new XemBieudoBarChartListener());
        
        tkdtQuyFrm.setVisible(true);
    }
    
    
    class ThongkeQuyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                khoangthoigian = tkdtQuyFrm.getKhoangThoigian();
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
                        tkdtQuyFrm.tblHienthiTKDTQuy(thongkeDoanhthuQuy(khoangthoigian));
                        tkdtQuyFrm.showMessage("Bạn đang xem thống kê theo quý");
                    }
                } else {
                    tkdtQuyFrm.tblHienthiTKDTQuy(thongkeDoanhthuQuy(khoangthoigian));
                    tkdtQuyFrm.showMessage("Bạn đang xem thống kê theo quý");
                }
//                tkdtQuyFrm.tblHienthiTKDTQuy(thongkeDoanhthuQuy(khoangthoigian));
//                tkdtQuyFrm.showMessage("Bạn đang xem thống kê theo quý");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    class InbaocaoThongkeTheoQuyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            khoangthoigian = tkdtQuyFrm.getKhoangThoigian();
            ArrayList<ThongkeDoanhthu> listDatas = thongkeDoanhthuQuy(khoangthoigian);
            try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("BaocaoThongkeQuy - "+new Date().toString()+".pdf"));
            document.open();
            document.add(new Paragraph("Báo cáo doanh thu theo quý", FontFactory.getFont(FontFactory.TIMES_ITALIC)));
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
                ArrayList<ThongkeDoanhthu> listDataDoanhthuQuy = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = tkdtQuyFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuQuy = thongkeDoanhthuQuy(new KhoangThoigian(tungay, denngay));
                System.out.println("listData :" + listDataDoanhthuQuy);
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int i = 0; i < listDataDoanhthuQuy.size(); i++) {
                    pieDataset.setValue(listDataDoanhthuQuy.get(i).getTenThongke(), listDataDoanhthuQuy.get(i).getDoanhthu());
                }
                JFreeChart chart = ChartFactory.createPieChart("Doanh thu quý", pieDataset, true, true, true);
                PiePlot p = (PiePlot) chart.getPlot();
                ChartFrame frame = new ChartFrame("Pie Chart thống kê doanh thu theo quý", chart);
                frame.setVisible(true);
                frame.setSize(800, 600);
                tkdtQuyFrm.showMessage("Bạn đang xem biểu đồ Pie Chart thống kê doanh thu theo quý");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class XemBieudoBarChartListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<ThongkeDoanhthu> listDataDoanhthuQuy = new ArrayList<ThongkeDoanhthu>();
                khoangthoigian = tkdtQuyFrm.getKhoangThoigian();
                String tungay = khoangthoigian.getTungay();
                String denngay = khoangthoigian.getDenngay();
                if (tungay == null || tungay.equalsIgnoreCase("")) {
                    tungay = "2000-01-01";
                }
                if (denngay == null || denngay.equalsIgnoreCase("")) {
                    denngay = "2050-01-01";
                }
                listDataDoanhthuQuy = thongkeDoanhthuQuy(new KhoangThoigian(tungay, denngay));
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int i = 0; i < listDataDoanhthuQuy.size(); i++) {
                    String[] thang = listDataDoanhthuQuy.get(i).getTenThongke().split("/");
                    dataset.setValue(listDataDoanhthuQuy.get(i).getDoanhthu(), listDataDoanhthuQuy.get(i).getTenThongke(), "");
                }
                JFreeChart chart = ChartFactory.createBarChart("Doanh thu quý", "Biểu đồ Bar Chart", "VND", dataset, PlotOrientation.VERTICAL, false, true, false);
                CategoryPlot p = (CategoryPlot) chart.getPlot();
                p.setRangeGridlinePaint(Color.BLACK);
                ChartFrame frame = new ChartFrame("Bar Chart thống kê doanh thu theo quý", chart);
                frame.setVisible(true);
                frame.setSize(1300, 800);
                tkdtQuyFrm.showMessage("Bạn đang xem biểu đồ Bar Chart thống kê doanh thu theo quý");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ArrayList<ThongkeDoanhthu> thongkeDoanhthuQuy(KhoangThoigian khoangthoigian) {
//        System.out.println("thongkeDoanhthuQuy  ---- START");
        String sqlQuery = "SELECT  quarter(ngaytra) as quy, year(ngaytra) as nam, SUM(tongtien) as doanhthu "
                + "FROM tblHoadon "
                + "group by year(ngaytra),quarter(ngaytra) "
                + "order by  year(ngaytra) desc,quarter(ngaytra) desc";

        ArrayList<ThongkeDoanhthu> listDataDoanhthuQuy = new ArrayList<ThongkeDoanhthu>();
        ThongkeDoanhthu tkdt = null;
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                String quy = rs.getString("quy");
                String nam = rs.getString("nam");
                String tenThongke = quy + "/" + nam;
                float doanhthu = rs.getFloat("doanhthu");
                tkdt = new ThongkeDoanhthu(tenThongke, doanhthu);
                listDataDoanhthuQuy.add(tkdt);
            }
        } catch (Exception e) {
            Logger.getLogger("--- method listDataThongkeDoanhthuQuy exception :");
        } finally {
            try {
                con.close();
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ThongkeDoanhthuQuyCtr.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listDataDoanhthuQuy;
    }
}
