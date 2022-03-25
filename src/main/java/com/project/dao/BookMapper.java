package com.project.dao;

import com.project.pojo.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    int addBook(Books book);

    int update(Books books);

    int delete(int id);

    Books queryBookById(int id);

    List<Books> queryAllBook();

}
