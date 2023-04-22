package com.example.mini_project.repository;

import com.example.mini_project.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"james","male"," I'm seeking an internship where I can apply my skills in content creation and increase my experience in digital marketing","@Mr. James","https://wallpaperaccess.com/full/4595687.jpg","https://api.istad.co/media/image/835a7298-dbab-448d-8229-ee8a555c4846.png","https://previews.123rf.com/images/nadiinko/nadiinko2001/nadiinko200100038/137769042-software-development-seamless-pattern-with-flat-line-icons-programming-language-background.jpg","james@gmail.com"));

        add(new Author(1002,"buna","male"," I'm seeking a full-time opportunity where I can employ my programming skills.I'm known for my friendliness and enthusiasm about my work.","@Mr. Buna","https://1fid.com/wp-content/uploads/2022/07/boy-anime-wallpaper-image-for-profile-pic-84.jpg","https://api.istad.co/media/image/c8c41751-3bc0-4f07-9658-7d95efbae692.png","https://cdn2.vectorstock.com/i/1000x1000/60/11/business-doodle-icons-background-or-pattern-vector-21116011.jpg","buna@gmail.com"));

        add(new Author(1003,"jena","female","I'm passionate about writing engaging content for businesses. I specialise in topics like technology, travel and food.","@Mrs. Jena","https://aniyuki.com/wp-content/uploads/2022/03/aniyuki-cute-anime-avatar-profile-picture-7.jpg","https://api.istad.co/media/image/b9bf96d7-c352-4533-8025-f017517ba648.png","https://i.pinimg.com/originals/c5/e6/14/c5e6147f2f1abeca7d952556a09b2b83.png","jena@gmail.com"));

        add(new Author(1004,"rona","male","I'm passionate about social justice. I'm currently working as an assistant for Martin Law.","@Mr. Rona","https://cdna.artstation.com/p/assets/images/images/053/054/138/large/avetetsuya-studios-alien.jpg","https://api.istad.co/media/image/b0b3f26d-4d21-45c6-9ed4-8e1f9f11e534.png","https://assets.hongkiat.com/uploads/seemless-icon-patterns/1-seamless-icon-pattern-download.jpg","rona@gmail.com"));

        add(new Author(1005,"goda","female","I work as a business consultant at Rosewood Consulting.","@Mrs. Goda","https://data.whicdn.com/images/356394578/original.jpg","https://api.istad.co/media/image/3d7beaad-309a-4f2f-91e2-b3be705ef3f6.png","https://img.freepik.com/free-vector/pattern-made-connection-icons_1061-383.jpg","goda@gmail.com"));
    }};

    public List<Author> getAllAuthor(){
        return authors;
    }
    public Author getAuthorID(int id){
        return authors.stream().filter(author -> author.getId()==id).findFirst().orElse(null);
    }
}
