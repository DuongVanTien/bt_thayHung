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
public class KhoangThoigian {
    
    private String tungay;
    private String denngay;

    public KhoangThoigian() {
    }

    public KhoangThoigian(String tungay, String denngay) {
        this.tungay = tungay;
        this.denngay = denngay;
    }

    public String getTungay() {
        return tungay;
    }

    public void setTungay(String tungay) {
        this.tungay = tungay;
    }

    public String getDenngay() {
        return denngay;
    }

    public void setDenngay(String denngay) {
        this.denngay = denngay;
    }
}
