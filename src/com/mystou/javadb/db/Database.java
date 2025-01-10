package com.mystou.javadb.db;

import java.sql.*;
import javax.swing.*;


public class Database {
    private Connection connect;

    public Database() {
        try {
            // เชื่อมต่อฐานข้อมูลโดยใช้ Config.java
            connect = Config.getConnection();
            JOptionPane.showMessageDialog(null, "เชื่อมต่อฐานข้อมูลสำเร็จ!", "สถานะการเชื่อมต่อ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ไม่สามารถเชื่อมต่อฐานข้อมูลได้!", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql, Object... params) throws Exception {
        PreparedStatement stmt = connect.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt.executeQuery();
    }

    public boolean executeUpdate(String sql, Object... params) throws Exception {
        PreparedStatement stmt = connect.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
        return stmt.executeUpdate() > 0;
    }

    public boolean addBook(String bookName) {
        String sql = "INSERT INTO books (book_name) VALUES (?)";
        try {
            return executeUpdate(sql, bookName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(String bookName) {
        String sql = "DELETE FROM books WHERE book_name = ?";
        try {
            return executeUpdate(sql, bookName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(String oldName, String newName) {
        String sql = "UPDATE books SET book_name = ? WHERE book_name = ?";
        try {
            return executeUpdate(sql, newName, oldName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
