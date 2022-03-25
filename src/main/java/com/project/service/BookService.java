package com.project.service;

import com.project.pojo.Books;

import java.util.List;

public interface BookService {
    int addBook(Books book);

    int update(Books books);

    int deleteBookById(int id);

    Books queryBookById(int id);

    List<Books> queryAllBook();


}
