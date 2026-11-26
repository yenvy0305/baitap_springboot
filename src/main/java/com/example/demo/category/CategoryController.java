package com.example.demo.category;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping({"", "/"})
	public String index() {
		return "redirect:/admin/categories/searchpaginated?page=1&size=3";
	}

	@GetMapping("/searchpaginated")
	public String search(Model model,
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "page", required = false) Optional<Integer> page,
			@RequestParam(name = "size", required = false) Optional<Integer> size) {

		int pageSize = size.filter(value -> value > 0 && value <= 100).orElse(3);
		int currentPage = page.filter(value -> value > 0).orElse(1);
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sort);

		Page<Category> resultPage = StringUtils.hasText(name)
				? categoryService.findByNameContaining(name.trim(), pageable)
				: categoryService.findAll(pageable);

		// Keep page links within range if rows were deleted from the last page.
		if (resultPage.getTotalPages() > 0 && currentPage > resultPage.getTotalPages()) {
			currentPage = resultPage.getTotalPages();
			pageable = PageRequest.of(currentPage - 1, pageSize, sort);
			resultPage = StringUtils.hasText(name)
					? categoryService.findByNameContaining(name.trim(), pageable)
					: categoryService.findAll(pageable);
		}

		int totalPages = resultPage.getTotalPages();
		if (totalPages > 0) {
			int start = Math.max(1, currentPage - 2);
			int end = Math.min(totalPages, start + 4);
			start = Math.max(1, end - 4);
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().toList();
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("name", name == null ? "" : name);
		model.addAttribute("categoryPage", resultPage);
		return "admin/category/list";
	}

	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category/form";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		try {
			model.addAttribute("category", categoryService.findById(id));
			return "admin/category/form";
		} catch (IllegalArgumentException ex) {
			redirectAttributes.addFlashAttribute("message", ex.getMessage());
			return "redirect:/admin/categories/searchpaginated?page=1&size=3";
		}
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("category") Category category,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "admin/category/form";
		}
		categoryService.save(category);
		redirectAttributes.addFlashAttribute("message", "Đã lưu danh mục.");
		return "redirect:/admin/categories/searchpaginated?page=1&size=3";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		categoryService.deleteById(id);
		redirectAttributes.addFlashAttribute("message", "Đã xóa danh mục.");
		return "redirect:/admin/categories/searchpaginated?page=1&size=3";
	}
}
