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
public class TruyenNhapkho {
    private Date ngayvao;
    private String maTruyen;
    private float gianhap;
    private int soluongnhap;
    private String ghichu;

    public TruyenNhapkho() {
    }

    public TruyenNhapkho(Date ngayvao, String maTruyen, float gianhap, int soluongnhap, String ghichu) {
        this.ngayvao = ngayvao;
        this.maTruyen = maTruyen;
        this.gianhap = gianhap;
        this.soluongnhap = soluongnhap;
        this.ghichu = ghichu;
    }

    public Date getNgayvao() {
        return ngayvao;
    }

    public void setNgayvao(Date ngayvao) {
        this.ngayvao = ngayvao;
    }

    public String getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(String maTruyen) {
        this.maTruyen = maTruyen;
    }

    public float getGianhap() {
        return gianhap;
    }

    public void setGianhap(float gianhap) {
        this.gianhap = gianhap;
    }

    public int getSoluong() {
        return soluongnhap;
    }

    public void setSoluong(int soluongnhap) {
        this.soluongnhap = soluongnhap;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
