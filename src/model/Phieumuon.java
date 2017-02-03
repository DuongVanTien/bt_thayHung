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
public class Phieumuon {
    private String id;
    private String maPhieumuon;
    private Khachhang khachhang;
    private Truyen[] truyen;
    private Nhanvien nhanvien;
    private String trangthai;

    public Phieumuon() {
    }

    public Phieumuon(String id, String maPhieumuon, Khachhang khachhang, Truyen[] truyen, Nhanvien nhanvien, String trangthai) {
        this.id = id;
        this.maPhieumuon = maPhieumuon;
        this.khachhang = khachhang;
        this.truyen = truyen;
        this.nhanvien = nhanvien;
        this.trangthai = trangthai;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getMaPhieu() {
        return maPhieumuon;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieumuon = maPhieu;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public Truyen[] getTruyen() {
        return truyen;
    }

    public void setTruyen(Truyen[] truyen) {
        this.truyen = truyen;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
