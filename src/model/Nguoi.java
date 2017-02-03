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
public class Nguoi {
    private String hoten;
    private String soMTND;
    private String diachi;
    private String sodienthoai;
    
    public Nguoi() {
    }

    public Nguoi(String hoten, String soMTND, String diachi, String sodienthoai) {
        this.hoten = hoten;
        this.soMTND = soMTND;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSoMTND() {
        return soMTND;
    }

    public void setSoMTND(String soMTND) {
        this.soMTND = soMTND;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
}
