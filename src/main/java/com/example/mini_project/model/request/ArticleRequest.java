package com.example.mini_project.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    @NotEmpty(message = "Title can not be empty!!")
    private String title;
    @NotEmpty(message = "Description can not be empty!!!")
    private String description;
    private MultipartFile file;
    private int authorID;
    private int[] categoryID;
}
