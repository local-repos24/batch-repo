package com.example.filereader.writer;

import com.example.filereader.model.Product;
import com.example.filereader.repository.FileItemRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileItemWriter implements ItemWriter<Product> {
    @Autowired
    private FileItemRepository fileItemRepository;

    @Override
    public void write(Chunk<? extends Product> product) throws Exception {
        fileItemRepository.saveAll(product);
    }
}
