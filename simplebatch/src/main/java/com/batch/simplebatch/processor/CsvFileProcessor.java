package com.batch.simplebatch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.simplebatch.entity.Product;

@Component
public class CsvFileProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product item) throws Exception {
		return item;
	}

}
