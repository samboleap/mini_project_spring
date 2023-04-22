package com.example.mini_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String fullname;
    private String gender;
    private String bio;
    private String userName;
    private String profileImg;
    private String img;
    private String bgImg;
    private String email;
}
