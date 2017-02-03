/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tienduongvan
 */
public class Nhanvien extends Nguoi{
    private String maNhanvien;
    private Nguoi nguoi;
    private String chucvu;
    private String tenTaikhoan;
    private String matkhau;

    public Nhanvien() {
    }

    public Nhanvien(String maNhanvien, Nguoi nguoi, String chucvu, String tenTaikhoan, String matkhau) {
        super();
        this.maNhanvien = maNhanvien;
        this.nguoi = nguoi;
        this.chucvu = chucvu;
        this.tenTaikhoan = tenTaikhoan;
        this.matkhau = matkhau;
    }

    public String getMaNhanvien() {
        return maNhanvien;
    }

    public void setMaNhanvien(String maNhanvien) {
        this.maNhanvien = maNhanvien;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getTenTaikhoan() {
        return tenTaikhoan;
    }

    public void setTenTaikhoan(String tenTaikhoan) {
        this.tenTaikhoan = tenTaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
