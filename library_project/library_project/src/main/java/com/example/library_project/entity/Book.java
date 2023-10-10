package com.example.library_project.entity;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private String genre;
    private LocalDate dateOfRelease;

    public Book() {
    }

    public Book(String title, Author author, String genre, LocalDate dateOfRelease) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.dateOfRelease = dateOfRelease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
