/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author tienduongvan
 */
public class Hoadon {
    private String maHoadon;
    private Phieumuon phieumuon;
    private Khachhang khachhang;
    private Nhanvien nhanvien;
    private Date ngaytra;
    private float tongtien;
    
    public Hoadon() {
    }

    public Hoadon(String maHoadon, Phieumuon phieumuon, Khachhang khachhang, Nhanvien nhanvien, Date ngaytra, float tongtien) {
        this.maHoadon = maHoadon;
        this.phieumuon = phieumuon;
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        this.ngaytra = ngaytra;
        this.tongtien = tongtien;
    }

    public String getMaHoadon() {
        return maHoadon;
    }

    public void setMaHoadon(String maHoadon) {
        this.maHoadon = maHoadon;
    }

    public Phieumuon getPhieumuon() {
        return phieumuon;
    }

    public void setPhieumuon(Phieumuon phieumuon) {
        this.phieumuon = phieumuon;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
}
