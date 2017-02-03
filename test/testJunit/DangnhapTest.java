package testJunit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tienduongvan
 */
public class DangnhapTest {

    public DangnhapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /*  test ok  */
    @Test
    public void testDangnhapPhuhop() {
        MyTest myTest = new MyTest();
        String taikhoan = "duongyen";
        String matkhau = "duongyen";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==true){
            JOptionPane.showConfirmDialog(null, "JUnit test OK. Tài khoản đăng nhập phù hợp");
        }
        assertEquals(true, result);
    }

    /*  test fail,  empty  */
    @Test
    public void testDangnhapEmpty() {
        MyTest myTest = new MyTest();
        String taikhoan = "";
        String matkhau = "";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tài khoản và mật khẩu không được bỏ trống");
        }
        assertEquals(true, result);
    }

    /*  test fail, taikhoan empty  */
    @Test
    public void testDangnhapTaikhoanEmpty() {
        MyTest myTest = new MyTest();
        String taikhoan = "";
        String matkhau = "duongyen";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tài khoản không được bỏ trống");
        }
        assertEquals(true, result);
    }

    /*  test fail, matkhau empty  */
    @Test
    public void testDangnhapMatkhauEmpty() {
        MyTest myTest = new MyTest();
        String taikhoan = "duongyen";
        String matkhau = "";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Mật khẩu không được bỏ trống");
        }
        assertEquals(true, result);
    }

    /*  test length > 30 ky tu  */
    @Test
    public void testDangnhapTooLength() {
        MyTest myTest = new MyTest();
        String taikhoan = "duong yen la chi gai yeu quy cua toi, Me tuyet voi nhat";
        String matkhau = "duong yen la chi gai yeu quy cua toi, Me tuyet voi nhat";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên tài khoản và mật khẩu không được lớn hơn 30 ký tự");
        }
        assertEquals(true, result);
    }
    
    /*  test length > 30 ky tu  */
    @Test
    public void testDangnhapMatkhauTooLength() {
        MyTest myTest = new MyTest();
        String taikhoan = "duongyen";
        String matkhau = "duong yen la chi gai yeu quy cua toi, Me tuyet voi nhat";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên mật khẩu không được lớn hơn 30 ký tự");
        }
        assertEquals(true, result);
    }
    
    /*  test length > 30 ky tu  */
    @Test
    public void testDangnhapTaikhoanTooLength() {
        MyTest myTest = new MyTest();
        String taikhoan = "duong yen la chi gai yeu quy cua toi, Me tuyet voi nhat";
        String matkhau = "duongyen";
        boolean result = myTest.testDangnhap(taikhoan, matkhau);
        if(result==false){
            JOptionPane.showConfirmDialog(null, "JUnit test Fail. Tên tài khoản không được lớn hơn 30 ký tự");
        }
        assertEquals(true, result);
    }
}
