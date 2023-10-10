package com.example.library_project.controller;

import com.example.library_project.entity.Book;
import com.example.library_project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/book")
public class BookController {
    @Autowired
    BookService bookService;


    @GetMapping("/show-all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public Book addBook(Book book){
        bookService.addBook(book);
        System.out.println("Book added to library");
        return book;
    }

    @GetMapping("/show-by-title/{title}")
    public Optional<Book> getBookByTitle(String title){
        return bookService.getBookByTitle(title);
    }




}
