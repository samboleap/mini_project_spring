package com.example.mini_project.service.serviceimpl;

import com.example.mini_project.model.Article;
import com.example.mini_project.repository.ArticleRepository;
import com.example.mini_project.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    ArticleRepository articleRepository;
    ArticleServiceImpl(){
        articleRepository = new ArticleRepository();
    }
    @Override
    public List<Article> getAllArticle() {
        return articleRepository.getAllArticle();
    }

    @Override
    public List<Article> getArtByAuthName(String name) {
        return articleRepository.getArtByAuthName(name);
    }

    @Override
    public List<Article> getArtByCatID(int id) {
        return articleRepository.getArtByCatID(id);
    }

    @Override
    public Article getArtByID(int id) {
        return articleRepository.getArticleByID(id);
    }

    @Override
    public void addNewArt(Article article) {
        articleRepository.addNewArticle(article);
    }

    @Override
    public void editArt(Article article) {
        articleRepository.editArticle(article);
    }

    @Override
    public void removeArt(Article article) {
        articleRepository.removeArticle(article);
    }


}
