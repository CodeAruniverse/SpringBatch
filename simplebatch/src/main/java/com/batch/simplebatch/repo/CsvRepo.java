package com.batch.simplebatch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.simplebatch.entity.Product;

@Repository
public interface CsvRepo extends JpaRepository<Product, Integer>{

}
