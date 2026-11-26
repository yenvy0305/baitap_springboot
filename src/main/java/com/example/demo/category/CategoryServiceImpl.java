package com.example.demo.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return categoryRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Category> findByNameContaining(String keyword, Pageable page) {
		return categoryRepository.findByNameContaining(keyword, page);
	}

	@Override
	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Không tìm thấy danh mục #" + id));
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}
}
