package com.app.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilder;
import org.springframework.batch.core.configuration.annotation.StepBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.batch.listener.MyJobListener;
import com.app.batch.processor.DataProcessor;
import com.app.batch.reader.DataReader;
import com.app.batch.writer.DataWriter;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository; // Inject JobRepository

    @Bean
    public Step stepA() {
        return new StepBuilder("stepA", jobRepository) // Use StepBuilder directly
            .<String, String>chunk(50)
            .reader(new DataReader())
            .processor(new DataProcessor())
            .writer(new DataWriter())
            .build();
    }

    @Bean
    public Job jobA() {
        return new JobBuilder("jobA", jobRepository) // Use JobBuilder directly
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(stepA())
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new MyJobListener();
    }
}