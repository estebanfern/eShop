package com.mishop.main.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

    private Logger logger = LoggerFactory.getLogger(StorageService.class);

    private final String FULL_PATH = "C:\\Users\\msi\\Desktop\\eshop\\src\\main\\resources\\static\\img\\data\\";

    private final String SEMI_PATH = "C:\\Users\\msi\\Desktop\\eshop\\src\\main\\resources\\static";

    public String saveFile(MultipartFile file) throws IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = timestamp.toInstant().toEpochMilli() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename());
        Path uploadPath = Paths.get(FULL_PATH);
        Path filePath = uploadPath.resolve(fileName);
        InputStream inputStream = file.getInputStream();
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        return "/img/data/" + fileName;
    }

    public void deleteFile (String fileName) throws IOException {
        fileName = fileName.replaceAll("/img/data/", "");
        logger.info(fileName);
        Path uploadPath = Paths.get(FULL_PATH);
        Path filePath = uploadPath.resolve(fileName);
        Files.delete(filePath);
    }

}
