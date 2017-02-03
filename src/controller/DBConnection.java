/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tienduongvan
 */
public class DBConnection {
    private static Connection con = null;
    
    public static Connection getConnect(){
        String dbUrl = "jdbc:mysql://localhost:3306/QLCuahangThueTruyen";
        String dbClass = "com.mysql.jdbc.Driver";
        try {
            Class.forName(dbClass);
            con = (Connection) DriverManager.getConnection(dbUrl, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return con;
    }
}
