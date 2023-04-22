package com.example.mini_project.service.serviceimpl;

import com.example.mini_project.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    Path fileLocationStorage;
    FileUploadServiceImpl(){
        fileLocationStorage = Paths.get("D:\\Istad 1st gen\\Spring\\mini-project\\mini_project\\src\\main\\resources\\static\\img\\ImagesAdding");
    }
    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();

        if (fileName!=null){

            if (fileName.contains("..")){
                System.out.println("FileName is incorrect!!!");
                return null;
            }
        String[] filePaths = fileName.split("\\.");
        fileName = UUID.randomUUID()+"."+filePaths[1];

            Path resolvedPath = fileLocationStorage.resolve(fileName);
            Files.copy(file.getInputStream(), resolvedPath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        else return null;
    }
}
