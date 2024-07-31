package com.example.filereader.data;

import lombok.Data;

@Data
public class ProductCSV {
    private Long id;
    private String code;
    private String name;
    private boolean isActive;
    private String payload;

    public ProductCSV() {
    }

}