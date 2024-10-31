package com.app.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	public void beforeJob(JobExecution je) {
		System.out.println(je.getStartTime());
		System.out.println(je.getStatus());
	}
	
	public void afterJob(JobExecution je) {
		System.out.println(je.getStartTime());
		System.out.println(je.getStatus());
	}
}
