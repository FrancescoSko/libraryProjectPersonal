package com.example.library_project.service;

import com.example.library_project.entity.Book;
import com.example.library_project.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks(){
        return bookDAO.findAll();
    }

   public void addBook(Book book){
        this.bookDAO.save(book);
       System.out.println("New book added to your library");
   }

   public Optional<Book> getBookByTitle(String title){
        for(Book book : bookDAO.findAll()){
            if(book.getTitle().equals(title)){
                return Optional.of(book);
            }
        } return Optional.empty();
   }


   public Optional<Book> getBookByGenre(String genre){
        for(Book book : bookDAO.findAll()){
            if(book.getGenre().equals(genre)){
                return Optional.of(book);
            }
        } return Optional.empty();
   }


   public String deleteAllBooks(){
        this.bookDAO.deleteAll();
        return "All books have been eliminated from the library!";
   }


   public Optional<String> deleteBookByTitle(String title){
        Optional<Book> bookOptional = bookDAO.findAll().stream().filter(book -> book.getTitle().equals(title)).findAny();

        if(bookOptional.isPresent()){
            Book bookForDelete = bookOptional.get();
            bookDAO.delete(bookForDelete);
            return Optional.of("The book : " + title + " has been removed from library!");
        } else {
            return Optional.of("Book: " + title + " not found");
        }
   }






}
