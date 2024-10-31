package com.app.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.batch.listener.MyJobListener;
import com.app.batch.processor.DataProcessor;
import com.app.batch.reader.DataReader;
import com.app.batch.writer.DataWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private StepBuilderFactory sf;
	
	@Autowired
	private JobBuilderFactory jf;
	
	
	@Bean
	public Step stepA() {
		return sf.get("stepA")
			.<String, String>chunk(50)
			.reader(new DataReader())
			.processor(new DataProcessor())
			.writer(new DataWriter())
			.build();
	}
	
	@Bean
	public Job jobA() {
		return jf.get("jobA")
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
