package com.example.library_project.service;

import com.example.library_project.entity.Author;
import com.example.library_project.entity.Book;
import com.example.library_project.repository.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    public List<Author> getAllAuthors() {
        return authorDAO.findAll();
    }

    public Author addAuthor(Author author) {
        this.authorDAO.save(author);
        System.out.println("A new author added to your library!");
        return author;
    }

    public Optional<Author> getAuthorByName(String name) {
        for (Author author : authorDAO.findAll()) {
            if (author.getName().equals(name)) {
                return Optional.of(author);
            }
        }
        return Optional.empty();
    }

   public Optional<Author> getAuthorBySurname(String surname){
        for(Author author : authorDAO.findAll()){
            if(author.getSurname().equals(surname)){
                return Optional.of(author);
            }
        } return Optional.empty();
   }

   public String deleteAllAuthors(){
        authorDAO.deleteAll();
        return "All authors have been eliminated from the library";
    }

    public Optional<String> deleteAuthorByName(String name){
        Optional<Author> authorOptional = authorDAO.findAll().stream().filter(author -> author.getName().equals(name)).findAny();

        if(authorOptional.isPresent()){
            Author authorForDelete = authorOptional.get();
            authorDAO.delete(authorForDelete);
            return Optional.of("The author : " + name + " has been removed from library!");
        } else {
            return Optional.of("Author: " + name + " not found");
        }
    }









}