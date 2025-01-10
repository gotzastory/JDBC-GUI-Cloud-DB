package com.mystou.javadb.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mystou.javadb.db.Database;
import com.mystou.javadb.m.Books;

public class BooksImpl implements BooksInterface {
    private Database db;

    public BooksImpl() {
        db = new Database();
    }

    @Override
    public List<Books> selectAll() {
        List<Books> booksList = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (ResultSet rs = db.executeQuery(sql)) {
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("book_name"));
                booksList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }

    @Override
    public boolean addBook(String name) {
        String sql = "INSERT INTO books (book_name) VALUES (?)";
        try {
            return db.executeUpdate(sql, name);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, String name) {
        String sql = "UPDATE books SET book_name = ? WHERE book_id = ?";
        try {
            return db.executeUpdate(sql, name, id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM books WHERE book_id = ?";
        try {
            return db.executeUpdate(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Books searchById(int id) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try (ResultSet rs = db.executeQuery(sql, id)) {
            if (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("book_name"));
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Books> searchByKeyword(String keyword) {
        List<Books> booksList = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE book_name LIKE ?";
        try (ResultSet rs = db.executeQuery(sql, "%" + keyword + "%")) {
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("book_name"));
                booksList.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return booksList;
    }
}
