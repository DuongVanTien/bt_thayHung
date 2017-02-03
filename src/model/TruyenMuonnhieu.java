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
public class TruyenMuonnhieu {
    private Truyen truyen;
    private int tongluot;
    private float tongtien;

    public TruyenMuonnhieu() {
    }

    public TruyenMuonnhieu(Truyen truyen, int tongluot, float tongtien) {
        this.truyen = truyen;
        this.tongluot = tongluot;
        this.tongtien = tongtien;
    }

    public Truyen getTruyen() {
        return truyen;
    }

    public void setTruyen(Truyen truyen) {
        this.truyen = truyen;
    }

    public int getTongluot() {
        return tongluot;
    }

    public void setTongluot(int tongluot) {
        this.tongluot = tongluot;
    }

    public float getTongtien() {
        return tongtien;
    }

    public void setTongtien(float tongtien) {
        this.tongtien = tongtien;
    }
}
