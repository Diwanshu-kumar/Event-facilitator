package com.event.facilitator.imageUpload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadImage(String path,MultipartFile file) throws IOException;
}
