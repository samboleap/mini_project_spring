package com.example.mini_project.service;

import com.example.mini_project.model.Article;

import java.util.List;


public interface ArticleService {
    List<Article> getAllArticle();
    List<Article> getArtByAuthName(String name);
    List<Article> getArtByCatID(int id);
    Article getArtByID(int id);
    void addNewArt(Article article);
    void editArt(Article article);
    void removeArt(Article article);
}
