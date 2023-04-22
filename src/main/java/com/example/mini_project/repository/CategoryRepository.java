package com.example.mini_project.repository;

import com.example.mini_project.model.Article;
import com.example.mini_project.model.Author;
import com.example.mini_project.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepository {

    private List<Category> cat = new ArrayList<>(){{
        add(new Category(1001,"ENGINEERING","This course will provide you with in-depth knowledge on how to build applications on the cloud."));

        add(new Category(1002,"FRAMEWORK","Spring Course will help in understanding about Spring framework."));

        add(new Category(1003,"ADMINISTRATOR","Linux is a family of open-source Unix-like operating systems based on the Linux kernel."));

        add(new Category(1004,"PROGRAMMING","Java is a high-level, class-based, object-oriented programming language"));

        add(new Category(1005,"DOCKER","Docker is a containerized tool that designed to make it easier to create."));
    }};
    public List<Category> getAllCategories(){
        return cat;
    }
    public Category getCatByID(int id){
        return cat.stream().filter(category -> category.getId()==id).findFirst().orElse(null);
    }
}
