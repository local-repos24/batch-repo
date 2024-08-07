package com.example.filereader.config;

import com.example.filereader.data.ProductCSV;
import com.example.filereader.listener.JobCompletionListener;
import com.example.filereader.model.Product;
import com.example.filereader.processor.FileItemProcessor;
import com.example.filereader.reader.FileItemReader;
import com.example.filereader.writer.FileItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MainJob {

    @Autowired
    FileItemReader fileItemReader;

    @Autowired
    FileItemProcessor fileItemProcessor;

    @Autowired
    FileItemWriter fileItemWriter;

    @Bean
    public Job productCsvJob(JobRepository jobRepository,
                            JobCompletionListener listener,
                             Step productCsvStep){
        return new JobBuilder("productCsvJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(productCsvStep)
                .build();
    }

    @Bean
    public Step productCsvStep(JobRepository jobRepository,
                               JobCompletionListener listener,
                               PlatformTransactionManager transactionManager){
        return new StepBuilder("productCsvStep", jobRepository)
                .<ProductCSV, Product>chunk(10, transactionManager)
                .reader(fileItemReader)
                .processor(fileItemProcessor)
                .writer(fileItemWriter)
                .listener(listener)
                .build();
    }

    /*
    @Bean
    public Job helloWorldJob(JobRepository jobRepository, Step helloWorldStep) {
        return new JobBuilder("helloWorldJob", jobRepository)
                .start(helloWorldStep)
                .build();
    }

    @Bean
    public Step helloWorldStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("helloWorldStep", jobRepository)
                .tasklet(new HelloWorldTasklet(), transactionManager)
                .build();
    }*/
}
