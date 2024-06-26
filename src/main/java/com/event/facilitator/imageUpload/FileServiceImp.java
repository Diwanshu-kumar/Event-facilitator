package com.event.facilitator.imageUpload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileServiceImp implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file name
        String fileName = UUID.randomUUID() + "_" +file.getOriginalFilename();


        //Full Path
        String filePath = path + File.separator+ fileName;

        //create folder if not created

        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }


        //File copy

        Files.copy(file.getInputStream(), Paths.get(filePath));
        String [] temp = filePath.split("\\\\");

        return "/"+temp[temp.length-2]+"/"+temp[temp.length-1];

    }
}
