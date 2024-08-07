package com.example.filereader.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job has started!!! :D");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Job has completed successfully!!!");
    }
}
