/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Nhaxuatban;
import model.Tacgia;
import model.Theloai;
import model.Truyen;

/**
 *
 * @author tienduongvan
 */
public class QuanlyTruyenCtr {
    
    private Connection con = null;
    private ResultSet rs = null, rsTacgia = null, rsNXB = null, rsTheloai = null;
    private PreparedStatement ps = null, psTacgia = null, psNXB = null, psTheloai = null;
    ArrayList<Truyen> danhsachtruyen = new ArrayList<Truyen>();
    private Truyen truyen;
    private Tacgia tacgia;
    private Theloai theloai;
    private Nhaxuatban nxb;
    
    public ArrayList<Truyen> danhsachTruyen() {
        String sql = "Select * from tblTruyen ";
        try {
            con = DBConnection.getConnect();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String maTruyen = rs.getString("maTruyen");
                String tenTruyen = rs.getString("tenTruyen");
                
                String maTacgia = rs.getString("maTacgia");
                String queryTacgia = "select * from tblTacgia where maTacgia = \'"+maTacgia+"\'";
                psTacgia = con.prepareStatement(queryTacgia);
                rsTacgia = psTacgia.executeQuery();
                if(rsTacgia.next()){
                    tacgia = new Tacgia(rsTacgia.getString("maTacgia"), rsTacgia.getString("tenTacgia"), "");
                }
                
                String maNXB = rs.getString("maNXB");
                String queryNXB = "select * from tblNhaxuatban where maNXB = \'"+maNXB+"\'";
                psNXB = con.prepareStatement(queryNXB);
                rsNXB = psNXB.executeQuery();
                if(rsNXB.next()){
                    nxb = new Nhaxuatban(rsNXB.getString("maNXB"), rsNXB.getString("tenNXB"), "","","");
                }
                
                String maTheloai = rs.getString("maTheloai");
                String queryTheloai = "select * from tblTheloai where maTheloai = \'"+maTheloai+"\'";
                psTheloai = con.prepareStatement(queryTheloai);
                rsTheloai = psTheloai.executeQuery();
                if(rsTheloai.next()){
                    theloai = new Theloai(rsTheloai.getString("maTheloai"), rsTheloai.getString("tenTheloai"), "");
                }
                
                Date namXuatban = rs.getDate("namXuatban");
                float giathue = rs.getFloat("giathue");
                String mota = rs.getString("mota");
                truyen = new Truyen(maTruyen, tenTruyen, tacgia, nxb, theloai, namXuatban, giathue, mota);
                danhsachtruyen.add(truyen);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (Exception e) {
            }
        }
        return danhsachtruyen;
    }
    
}
