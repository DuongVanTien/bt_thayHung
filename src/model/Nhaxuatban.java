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
public class Nhaxuatban {
    private String maNXB;
    private String tenNXB;
    private String diachi;
    private String sodienthoai;
    private String thongtinNXB;

    public Nhaxuatban() {
    }

    public Nhaxuatban(String maNXB, String tenNXB, String diachi, String sodienthoai, String thongtinNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.thongtinNXB = thongtinNXB;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
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

    public String getThongtinNXB() {
        return thongtinNXB;
    }

    public void setThongtinNXB(String thongtinNXB) {
        this.thongtinNXB = thongtinNXB;
    }
}
