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
public class Truyen {
    private String maTruyen;
    private String tenTruyen;
    private Tacgia tacgia;
    private Nhaxuatban nhaxuatban;
    private Theloai theloai;
    private Date namxuatban;
    private float giathue;
    private String mota;

    public Truyen() {
    }

    public Truyen(String maTruyen, String tenTruyen, Tacgia tacgia, Nhaxuatban nhaxuatban, Theloai theloai, Date namxuatban, float giathue, String mota) {
        this.maTruyen = maTruyen;
        this.tenTruyen = tenTruyen;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.theloai = theloai;
        this.namxuatban = namxuatban;
        this.giathue = giathue;
        this.mota = mota;
    }

    public String getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(String maTruyen) {
        this.maTruyen = maTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public Tacgia getTacgia() {
        return tacgia;
    }

    public void setTacgia(Tacgia tacgia) {
        this.tacgia = tacgia;
    }

    public Nhaxuatban getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(Nhaxuatban nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public Theloai getTheloai() {
        return theloai;
    }

    public void setTheloai(Theloai theloai) {
        this.theloai = theloai;
    }

    public Date getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(Date namxuatban) {
        this.namxuatban = namxuatban;
    }

    public float getGiathue() {
        return giathue;
    }

    public void setGiathue(float giathue) {
        this.giathue = giathue;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
