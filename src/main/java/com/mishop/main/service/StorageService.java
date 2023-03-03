package com.mishop.main.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.mishop.main.model.FileData;
import com.mishop.main.repository.FileDataRepository;

@Service
public class StorageService {
    
    

    @Autowired
    private FileDataRepository fileDataRepository;


    private final String FOLDER_PATH="C:/Users/sebas/Desktop/tresHermanos/primer_proyecto/eShop/src/main/resources/files/";


    public String saveFile(MultipartFile file) throws IOException {
        
        // Se obtienen los datos del request recibido
        String name = file.getOriginalFilename();
        String type = file.getContentType();
        String filePath = FOLDER_PATH + name;
        FileData fileData = fileDataRepository.save(new FileData(name, type, filePath));
        
        // Se guarda el archivo en el sistema de archivos
        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        } 
        return null;
    }

    public byte[] loadFile (String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        if (!fileData.isPresent()) {
            return null;
        }
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

}
