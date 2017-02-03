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
public class TruyenXuatkho {
    private Date ngayxuat;
    private String maTruyen;
    private float giaban;
    private int soluongxuat;
    private String ghichu;

    public TruyenXuatkho() {
    }

    public TruyenXuatkho(Date ngayxuat, String maTruyen, float giaban, int soluongxuat, String ghichu) {
        this.ngayxuat = ngayxuat;
        this.maTruyen = maTruyen;
        this.giaban = giaban;
        this.soluongxuat = soluongxuat;
        this.ghichu = ghichu;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public String getMaTruyen() {
        return maTruyen;
    }

    public void setMaTruyen(String maTruyen) {
        this.maTruyen = maTruyen;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public int getSoluongxuat() {
        return soluongxuat;
    }

    public void setSoluongxuat(int soluongxuat) {
        this.soluongxuat = soluongxuat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
