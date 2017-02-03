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
public class KhachhangMuonnhieu {
    private Khachhang khachhang;
    private int tongluot;
    private float tongtien;

    public KhachhangMuonnhieu() {
    }

    public KhachhangMuonnhieu(Khachhang khachhang, int tongluot, float tongtien) {
        this.khachhang = khachhang;
        this.tongluot = tongluot;
        this.tongtien = tongtien;
    }
}
