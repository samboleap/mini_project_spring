package com.example.mini_project.service.serviceimpl;


import com.example.mini_project.model.Category;
import com.example.mini_project.repository.CategoryRepository;
import com.example.mini_project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    CategoryServiceImpl(){categoryRepository = new CategoryRepository();}
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category getCatByID(int id) {
        return categoryRepository.getCatByID(id);
    }
}
