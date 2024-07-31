package com.example.filereader.processor;

import com.example.filereader.data.ProductCSV;
import com.example.filereader.model.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class FileItemProcessor implements ItemProcessor<ProductCSV, Product> {
    @Override
    public Product process(ProductCSV item) throws Exception {
        Product product = new Product();

        product.setId(item.getId());
        product.setCode(item.getCode());
        product.setName(item.getName());
        product.setActive(item.isActive());
        product.setPayload(item.getPayload());
        return product;
    }
}
