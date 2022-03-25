package com.project.service;

import com.project.dao.BookMapper;
import com.project.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int update(Books books) {
        return bookMapper.update(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.delete(id);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
