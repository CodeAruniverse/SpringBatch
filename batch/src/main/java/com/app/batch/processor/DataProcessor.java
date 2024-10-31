package com.app.batch.processor;

import org.springframework.batch.item.ItemProcessor;

public class DataProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		return item.toUpperCase();
	}

}
