package com.mishop.main.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String filePath;

    public FileData(String name, String type, String filePath) {
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }

    public FileData(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static Object builder() {
        return null;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }







}
