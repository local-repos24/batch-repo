package com.example.filereader.reader;

import com.example.filereader.data.ProductCSV;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Component
public class FileItemReader implements ItemReader<ProductCSV> {
    private FlatFileItemReader<ProductCSV> reader;
    private BufferedReader bufferedReader;

    public FileItemReader(){
        setUp();
    }

    private void setUp(){
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(new ClassPathResource("data.csv").getInputStream()));

            bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductCSV read() throws Exception{
        if(this.bufferedReader != null){
            String line = bufferedReader.readLine();
            if(line != null){
                String[] fields = line.split(",");
                if(fields.length>0){
                    ProductCSV product = new ProductCSV();
                    product.setId(Long.valueOf(fields[0]));
                    product.setCode(fields[1]);
                    product.setName(fields[2]);
                    product.setActive(Boolean.parseBoolean(fields[3]));
                    product.setPayload(fields[4]);
                    return product;
                }
            }
        }
        return null;
    }
}
