package com.example.demo.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Tên danh mục không được để trống")
	@Size(max = 120, message = "Tên danh mục tối đa 120 ký tự")
	@Column(nullable = false, length = 120)
	private String name;

	@Size(max = 500, message = "Đường dẫn hình tối đa 500 ký tự")
	@Column(length = 500)
	private String images;

	@Column(nullable = false)
	private boolean status = true;

	protected Category() {
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getImages() { return images; }
	public void setImages(String images) { this.images = images; }
	public boolean isStatus() { return status; }
	public void setStatus(boolean status) { this.status = status; }
}
