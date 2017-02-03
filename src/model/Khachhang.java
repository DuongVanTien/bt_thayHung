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
public class Khachhang extends Nguoi{
    private String maKhachhang;
    private Nguoi nguoi;

    public Khachhang() {
    }

    public Khachhang(String maKhachhang, Nguoi nguoi) {
        this.maKhachhang = maKhachhang;
        this.nguoi = nguoi;
    }

    public String getMaKhachhang() {
        return maKhachhang;
    }

    public void setMaKhachhang(String maKhachhang) {
        this.maKhachhang = maKhachhang;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }
}
