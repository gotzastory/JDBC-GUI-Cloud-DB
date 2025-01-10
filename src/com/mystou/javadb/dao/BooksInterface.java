package com.mystou.javadb.dao;

import java.util.List;

import com.mystou.javadb.m.Books;

public interface BooksInterface {
    List<Books> selectAll();
    boolean addBook(String name);
    boolean update(int id, String name);
    boolean delete(int id);
    Books searchById(int id);
    List<Books> searchByKeyword(String keyword);
}
