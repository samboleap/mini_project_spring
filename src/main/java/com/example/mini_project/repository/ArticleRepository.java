package com.example.mini_project.repository;

import com.example.mini_project.model.Article;
import com.example.mini_project.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class ArticleRepository {
    private List<Article> articleList = new ArrayList<>(){{

       add(new Article(1001,"DEVOPS ENGINEERING","This course will provide you with in-depth knowledge on how to build applications on the cloud.", new AuthorRepository().getAllAuthor().get(0),new Category[]{new CategoryRepository().getAllCategories().get(0)}));

       add(new Article(1002,"SPRING FRAMEWORK","Spring Course will help in understanding about Spring framework.",new AuthorRepository().getAllAuthor().get(1),new Category[]{new CategoryRepository().getAllCategories().get(1)}));

       add(new Article(1003,"LINUX ADMINISTRATOR","Linux is a family of open-source Unix-like operating systems based on the Linux kernel.", new AuthorRepository().getAllAuthor().get(2),new Category[] {new CategoryRepository().getAllCategories().get(2)}));

       add(new Article(1004,"JAVA PROGRAMMING","Java is a high-level, class-based, object-oriented programming language", new AuthorRepository().getAllAuthor().get(3), new Category[]{new CategoryRepository().getAllCategories().get(3)}));

       add(new Article(1005,"DOCKER","Docker is a containerized tool that designed to make it easier to create.",new AuthorRepository().getAllAuthor().get(4),new Category[] {new CategoryRepository().getAllCategories().get(4)}));

    }} ;
    public List<Article> getAllArticle(){
        return articleList;
    }
    public Article getArticleByID(int id){
        return articleList.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }
    public List<Article> getArtByAuthName(String name){
        return articleList.stream().filter(article -> Objects.equals(article.getAuthor().getUserName(), name)).toList();
    }
    public List<Article> getArtByCatID(int id){
        return articleList.stream().filter(article -> Arrays.stream(article.getCategory()).anyMatch(category -> category.getId()==id)).toList();
    }

    public void addNewArticle(Article article){
        articleList.add(article);
    }
    public void editArticle(Article article){

    }
    public void removeArticle(Article article){
        articleList.remove(article);
    }
}
