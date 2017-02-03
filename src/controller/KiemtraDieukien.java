/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

/**
 *
 * @author tienduongvan
 */
public class KiemtraDieukien {

    public boolean testDangnhap(String taikhoan, String matkhau) {

        if ((taikhoan == null || taikhoan.equalsIgnoreCase("")) && (matkhau == null || matkhau.equalsIgnoreCase(""))) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tài khoản và mật khẩu không được bỏ trống");
            return false;
        } else if ((taikhoan == null || taikhoan.equalsIgnoreCase("")) && (matkhau != null && !matkhau.equalsIgnoreCase(""))) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tài khoản không được bỏ trống");
            return false;
        } else if ((taikhoan != null || !taikhoan.equalsIgnoreCase("")) && (matkhau == null || matkhau.equalsIgnoreCase(""))) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Mật khẩu không được bỏ trống");
            return false;
        } else if (taikhoan.length() > 30 && matkhau.length() > 30) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên tài khoản và mật khẩu không được lớn hơn 30 ký tự");
            return false;
        } else if (taikhoan.length() > 30 && matkhau.length() < 30) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên tài khoản không được lớn hơn 30 ký tự");
            return false;
        } else if (taikhoan.length() < 30 && matkhau.length() > 30) {
//            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên mật khẩu không được lớn hơn 30 ký tự");
            return false;
        } else {
//            JOptionPane.showConfirmDialog(null, "JUnit test OK. Tài khoản đăng nhập phù hợp");
            return true;
        }
    }

    public boolean testNgaythangnam(String ngaythangnam) {
        if(ngaythangnam.equalsIgnoreCase("") || ngaythangnam==null || ngaythangnam.isEmpty()){
            return true;
        }
        String[] mangNgaythangnam = ngaythangnam.split("-");
        if (mangNgaythangnam.length == 3) {
            System.out.println("a");
            String strNam = mangNgaythangnam[0];
            for (int i = 0; i < strNam.length(); i++) {
                if (strNam.charAt(i) < '0' || strNam.charAt(i) > '9') {
                    return false;
                }
            }
            
            String strThang = mangNgaythangnam[1];
            for (int i = 0; i < strThang.length(); i++) {
                if (strThang.charAt(i) < '0' || strThang.charAt(i) > '9') {
                    return false;
                }
            }
            
            String strNgay = mangNgaythangnam[1];
            for (int i = 0; i < strNgay.length(); i++) {
                if (strNgay.charAt(i) < '0' || strNgay.charAt(i) > '9') {
                    return false;
                }
            }
            
            int nam = Integer.parseInt(mangNgaythangnam[0]);
            int thang = Integer.parseInt(mangNgaythangnam[1]);
            int ngay = Integer.parseInt(mangNgaythangnam[2]);
            
            if(nam<2000 || nam>2050 || thang<1 || thang>12 || ngay<1 || ngay>31){
                return false;
            }
 
            if(nam%400==0 || (nam%4==0 && nam%100!=0)){     // nam nhuan
                if(thang==2 && ngay>29){
                    return false;
                }
            }else{                                          // nam thuong
                if(thang==2 && ngay>28){
                    return false;
                }
            }
             
            if(thang==4 || thang==6 || thang==9 || thang==11 && ngay>30){
                return false;
            }
            System.out.println("b");
            System.out.println("---------------");
            return true;
        }
        return false;
    }
    
    
    /* ------ truong hop tungay > denngay ------*/
    public boolean testTungayDenngay(String tungay, String denngay) {
        
        KiemtraDieukien myTest = new KiemtraDieukien();
        if(myTest.testNgaythangnam(tungay) && myTest.testNgaythangnam(denngay)) {
            String[] mangTungay = tungay.split("-");
            int namTungay = Integer.parseInt(mangTungay[0]);
            int thangTungay = Integer.parseInt(mangTungay[1]);
            int ngayTungay = Integer.parseInt(mangTungay[2]);
//            System.out.println("namthangngay : "+namTungay+"/"+thangTungay+"/"+ngayTungay);
            
            String[] mangDenngay = denngay.split("-");
            int namDenngay = Integer.parseInt(mangDenngay[0]);
            int thangDenngay = Integer.parseInt(mangDenngay[1]);
            int ngayDenngay = Integer.parseInt(mangDenngay[2]);
//            System.out.println("namthangngay : "+namDenngay+"/"+thangDenngay+"/"+ngayDenngay);
            
            if(namTungay > namDenngay){
                return false;
            }
            
            if(namTungay==namDenngay && thangTungay>thangDenngay){
                return false;
            }
            
            if(namTungay==namDenngay  && thangTungay==thangDenngay && ngayTungay>ngayDenngay){
                return false;
            }
            
            return true;
        } 
        return false;
    }
    
    public static void main(String[] args) {
        KiemtraDieukien myTest = new KiemtraDieukien();
        System.out.println(myTest.testNgaythangnam("2012-02-20"));
    }

}
