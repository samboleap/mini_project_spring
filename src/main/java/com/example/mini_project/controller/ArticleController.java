package com.example.mini_project.controller;

import com.example.mini_project.model.Article;
import com.example.mini_project.model.Author;
import com.example.mini_project.model.Category;
import com.example.mini_project.model.request.ArticleRequest;
import com.example.mini_project.service.ArticleService;
import com.example.mini_project.service.AuthorService;
import com.example.mini_project.service.CategoryService;
import com.example.mini_project.service.FileUploadService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class ArticleController {
    ArticleService articleService;
    FileUploadService fileUploadService;
    AuthorService authorService;
    CategoryService categoryService;
    @Autowired
    ArticleController (ArticleService articleService,AuthorService authorService, FileUploadService fileUploadService, CategoryService categoryService){
        this.articleService = articleService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public String index(Model model){
        List<Article> articles = articleService.getAllArticle();
        List<Category> categories = categoryService.getAllCategory();
        List<Author> authors = authorService.getAllAuthor();
        model.addAttribute("articles",articles.stream().sorted((((o1, o2) ->
                o2.getId()- o1.getId()))));
        model.addAttribute("categories",categories);
        model.addAttribute("authors",authors);
        return "loadPage/index";
    }

    @GetMapping("/Users")
    public String getAllArticle(Model model ){
        List<Article> articles = articleService.getAllArticle();
        List<Author> authors = authorService.getAllAuthor();
        model.addAttribute("articles",articles);
        model.addAttribute("authors",authors);
        return "loadPage/allArticle";
    }
    @GetMapping("/profile/{profileId}/{UsersName}")
    public String profilePage(@PathVariable int profileId, @PathVariable String UsersName,Model model ){
        model.addAttribute("profileId",authorService.getAuthorID(profileId));
        model.addAttribute("UsersName",articleService.getArtByAuthName(UsersName));
        model.addAttribute("selectCategory",categoryService.getAllCategory());
        return "loadPage/viewUsersProfile";
    }

    @GetMapping("/Post")
    public String getNewForm(Model model)
    {
        model.addAttribute("articles", new ArticleRequest());
        model.addAttribute("authors", authorService.getAllAuthor());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "loadPage/newForm";
    }

    @PostMapping("/handleAddArticle")
    public String handleAddArticle(@Valid @ModelAttribute("article")  ArticleRequest article,
                                   BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            System.out.println("Errors has happened!!!");

            model.addAttribute("authors", authorService.getAllAuthor());
            return "loadPage/newForm";
        }

        List<Category> newCat = new ArrayList<>();
        for (int categories: article.getCategoryID()) {
            newCat.add(categoryService.getAllCategory().stream().filter(category -> category.getId()==categories).findFirst().orElse(null));
        }
        Category[] cat = newCat.toArray(new Category[newCat.size()]);

        Author newAuthor = authorService.getAllAuthor().stream().filter(author -> author.getId()== article.getAuthorID()).findFirst().orElse(null);
        try {
            String fileNames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(article.getFile());
            newAuthor.setImg(fileNames);

        }catch (Exception e){
            newAuthor.setImg("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error: " +e.getMessage());
        }

        newAuthor.setFullname(article.getFile().getName());
        newAuthor.setBio(article.getDescription());

        Article newArticle = new Article();
        newArticle.setTitle(article.getTitle());
        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == article.getAuthorID())
                .findFirst().orElse(null));

        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
        articleService.addNewArt(newArticle);
        newArticle.setCategory(cat);

        return "redirect:/";
    }
}