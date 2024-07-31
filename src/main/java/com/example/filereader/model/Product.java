package com.example.filereader.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    private Long id;
    private String code;
    private String name;

    @Column(name = "is_active")
    private boolean isActive;
    private String payload;
}


