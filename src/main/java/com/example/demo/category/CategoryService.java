package com.example.demo.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
	long count();
	Page<Category> findAll(Pageable pageable);
	Page<Category> findByNameContaining(String keyword, Pageable page);
	Category findById(Long id);
	Category save(Category category);
	void deleteById(Long id);
}
