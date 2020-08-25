package com.bca.tama.testing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdapterJDBC {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/hacktiv8_bcaf";
    private static final String user="root";
    private static final String password ="root";
    public static Connection getConnection(){
        Connection conn=null;
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("Connected to mysql server successfull");
        } catch (SQLException e) {
            System.out.println("connection error");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
