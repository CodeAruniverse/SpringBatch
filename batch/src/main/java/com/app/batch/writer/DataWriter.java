package com.app.batch.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class DataWriter implements ItemWriter<String> {

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		for(String item : chunk) {
			System.out.println(chunk);
		}		
	}

}
