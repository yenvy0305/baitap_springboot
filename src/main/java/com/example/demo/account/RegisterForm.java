package com.example.demo.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterForm {

	@NotBlank(message = "Tên đăng nhập không được để trống")
	@Size(min = 3, max = 50, message = "Tên đăng nhập phải từ 3 đến 50 ký tự")
	private String username;

	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không đúng định dạng")
	@Size(max = 150, message = "Email không được vượt quá 150 ký tự")
	private String email;

	@NotBlank(message = "Mật khẩu không được để trống")
	@Size(min = 8, max = 72, message = "Mật khẩu phải có từ 8 đến 72 ký tự")
	private String password;

	@NotBlank(message = "Vui lòng nhập lại mật khẩu")
	private String confirmPassword;

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getConfirmPassword() { return confirmPassword; }
	public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}
