package com.example.filereader.repository;

import com.example.filereader.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface FileItemRepository extends CrudRepository<Product, Long> {
}
