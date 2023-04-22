package com.example.mini_project.service.serviceimpl;

import com.example.mini_project.model.Author;
import com.example.mini_project.repository.AuthorRepository;
import com.example.mini_project.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthor();
    }

    @Override
    public Author getAuthorID(int id) {
        return null;
    }

}
