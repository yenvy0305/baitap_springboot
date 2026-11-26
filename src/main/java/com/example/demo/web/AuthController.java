package com.example.demo.web;

import com.example.demo.account.AccountService;
import com.example.demo.account.RegisterForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

	private final AccountService accountService;

	public AuthController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/")
	public String home() {
		return "web/home";
	}

	@GetMapping("/login")
	public String login() {
		return "web/login";
	}

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("registerForm", new RegisterForm());
		return "web/register";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerForm") RegisterForm form,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMessage", "Vui lòng kiểm tra lại thông tin đăng ký.");
			return "web/register";
		}

		try {
			accountService.register(form);
			return "redirect:/login?registered";
		} catch (IllegalArgumentException ex) {
			model.addAttribute("errorMessage", ex.getMessage());
			return "web/register";
		}
	}
}
