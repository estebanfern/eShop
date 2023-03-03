package com.mishop.main.controller.rest;

import java.io.IOException;
import java.util.List;

import org.codehaus.groovy.tools.shell.IO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mishop.main.model.FileData;
import com.mishop.main.repository.FileDataRepository;
import com.mishop.main.service.StorageService;

@RestController
public class FileRest {
    private static final String BASE_URL = "/api/file";
    private final FileDataRepository fileDataRepository;
    private final StorageService storageService;


    public FileRest(FileDataRepository fileDataRepository, StorageService storageService) {
        this.fileDataRepository = fileDataRepository;
        this.storageService = storageService;
    }

    @GetMapping(BASE_URL + "/list")
    public List<FileData> getProductos(){
        return fileDataRepository.findAll();
    }

    @GetMapping(BASE_URL + "/{file_name}")
    public ResponseEntity<?> getFile (@PathVariable String file_name) throws IOException{
        byte [] file = storageService.loadFile(file_name); //Get file from storage
        
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType
        .valueOf("image/png"))
        .body(file);
    }

    @PostMapping(BASE_URL + "/save")
    public ResponseEntity<?> saveFile(@RequestParam("image") MultipartFile file) throws IOException{ //Se obtiene la variable "image" del request
        String fileDataSaved = storageService.saveFile(file); //Save file to storage
        return new ResponseEntity<>(fileDataSaved, HttpStatus.OK);
    }

    
}
