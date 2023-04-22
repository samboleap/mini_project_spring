package com.example.mini_project.service;

import com.example.mini_project.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCatByID(int id);
}
