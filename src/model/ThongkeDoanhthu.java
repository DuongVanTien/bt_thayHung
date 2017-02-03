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
public class ThongkeDoanhthu {
    private String tenThongke;
    private float doanhthu;

    public ThongkeDoanhthu() {
    }

    public ThongkeDoanhthu(String tenThongke, float doanhthu) {
        this.tenThongke = tenThongke;
        this.doanhthu = doanhthu;
    }

    public String getTenThongke() {
        return tenThongke;
    }

    public void setTenThongke(String tenThongke) {
        this.tenThongke = tenThongke;
    }

    public float getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(float doanhthu) {
        this.doanhthu = doanhthu;
    }
}
