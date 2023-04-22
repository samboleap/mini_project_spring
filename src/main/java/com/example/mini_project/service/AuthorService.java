package com.example.mini_project.service;

import com.example.mini_project.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    Author getAuthorID(int id);
}
