package com.mystou.javadb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    // ใช้ Connection String จาก Supabase Dashboard
    private static final String URL = "URL ตาม connect ใน Supabase";
    private static final String USERNAME = "postgres"; // ค่า user จาก Supabase 
    private static final String PASSWORD = "YOUR-NAME(หาเอง)"; // ค่า password จาก Supabase

    // ฟังก์ชันสำหรับการเชื่อมต่อฐานข้อมูล
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}