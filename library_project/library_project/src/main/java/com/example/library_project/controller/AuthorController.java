package com.example.library_project.controller;

import com.example.library_project.entity.Author;
import com.example.library_project.service.AuthorService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library/author")

public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/show-all")
    public List<Author> getAllAuthors(){
      return authorService.getAllAuthors();
    }

    @PostMapping("/add")
    public Author addAnAuthor(Author author){
        authorService.addAuthor(author);
        return author;
    }

    @GetMapping("show-by-name/{name}")
    public Optional<Author> getAuthorByName(String name){
       return authorService.getAuthorByName(name);
    }

    @GetMapping("show-by-surname/{surname}")
    public Optional<Author> getAuthorBySurname(String surname){
        return authorService.getAuthorBySurname(surname);
    }

    @DeleteMapping("/delete-all")
    public String deleteAllAuthors(){
       return authorService.deleteAllAuthors();
    }

    @DeleteMapping("/delete-by-name/{name}")
    public Optional<String> deleteAuthorByName(String name){
        return authorService.deleteAuthorByName(name);
    }


}
