/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testJunit;

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
public class ThongkeDoanhthuTest {

    public ThongkeDoanhthuTest() {
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

    @Test  /*  test ok  */
    public void testNgaythangnam() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2012-03-25";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("testNgaythangnam : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test1() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "abc-ef-gh";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test1 : "+result);
        assertEquals(true, result);
    }
    
    /*--------------------Nam---------------------------*/
    @Test  /*  test false  */
    public void test2() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "1999-04-22";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test2 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test3() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2001-02-22";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test3 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test4() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2001-05-12";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test4 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test5() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2049-08-22";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test5 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test6() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2050-10-23";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test6 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test7() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2051-05-12";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test7 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test8() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2025-03-26";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test8 : "+result);
        assertEquals(true, result);
    }
    
    /*---------------- Thang -----------------*/
    
    @Test  /*  test false  */
    public void test9() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-00-22";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test9 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test10() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2015-01-23";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test10 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test11() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-02-12";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test11 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test12() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-11-23";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test12 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test13() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-12-12";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test13 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test14() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-13-22";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test14 : "+result);
        assertEquals(true, result);
    }
    
    /* ------------------Ngay---------------------- */
    
    @Test  /*  test false  */
    public void test15() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-11-00";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test15 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test16() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-11-01";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test16 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test17() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-11-02";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test17 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test18() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-08-30";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test18 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test19() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-08-31";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test19 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test20() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-08-32";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test20 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test ok  */
    public void test21() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-08-15";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test21 : "+result);
        assertEquals(true, result);
    }
    
    /* --------------------- thang 2 nam thuong -----------*/
    @Test  /*  test ok  */
    public void test22() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2015-02-28";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test22 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test23() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2015-02-29";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test23 : "+result);
        assertEquals(true, result);
    }
    
    
    /* --------------------- thang 2 nam nhuan -----------*/
    @Test  /*  test ok  */
    public void test24() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-02-29";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test24 : "+result);
        assertEquals(true, result);
    }
    
    @Test  /*  test false  */
    public void test25() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-02-30";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test25 : "+result);
        assertEquals(true, result);
    }
    
    
    /* ------------------ thang 4,6,9,11 co 30 ngay --------------*/   
    @Test  /*  test false  */
    public void test26() {
        MyTest myTest = new MyTest();
        String ngaythangnam = "2016-04-31";
        boolean result = myTest.testNgaythangnam(ngaythangnam);
        System.out.println("test26 : "+result);
        assertEquals(true, result);
    }
    
    /* ------------------- tungay > denngay ------------*/
    @Test
    /*  test false  */
    public void test27() {
        MyTest myTest = new MyTest();
        String tungay = "2015-08-20";
        String denngay = "2016-11-20";
        boolean result = myTest.testTungayDenngay(tungay, denngay);
        System.out.println("test27 : " + result);
        assertEquals(true, result);
    }
    
    @Test
    /*  test false  */
    public void test28() {
        MyTest myTest = new MyTest();
        String tungay = "2015-08-20";
        String denngay = "2012-11-20";
        boolean result = myTest.testTungayDenngay(tungay, denngay);
        System.out.println("test28 : " + result);
        assertEquals(true, result);
    }

}
