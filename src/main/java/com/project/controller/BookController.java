package com.project.controller;

import com.project.pojo.Books;
import com.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list =bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping("/update")
    public String update(Model model, Books book) {
        System.out.println(book);
        bookService.update(book);
        Books books = bookService.queryBookById(book.getBookId());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
