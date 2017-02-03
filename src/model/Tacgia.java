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
public class Tacgia {
    private String maTacgia;
    private String tenTacgia;
    private String thongtinTacgia;

    public Tacgia() {
    }

    public Tacgia(String maTacgia, String tenTacgia, String thongtinTacgia) {
        this.maTacgia = maTacgia;
        this.tenTacgia = tenTacgia;
        this.thongtinTacgia = thongtinTacgia;
    }

    public String getMaTacgia() {
        return maTacgia;
    }

    public void setMaTacgia(String maTacgia) {
        this.maTacgia = maTacgia;
    }

    public String getTenTacgia() {
        return tenTacgia;
    }

    public void setTenTacgia(String tenTacgia) {
        this.tenTacgia = tenTacgia;
    }

    public String getThongtinTacgia() {
        return thongtinTacgia;
    }

    public void setThongtinTacgia(String thongtinTacgia) {
        this.thongtinTacgia = thongtinTacgia;
    }
}
