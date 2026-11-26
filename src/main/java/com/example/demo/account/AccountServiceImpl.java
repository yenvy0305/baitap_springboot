package com.example.demo.account;

import java.util.Locale;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;

	public AccountServiceImpl(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
		this.accountRepository = accountRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public Account register(RegisterForm form) {
		String username = form.getUsername().trim();
		String email = form.getEmail().trim().toLowerCase(Locale.ROOT);

		if (accountRepository.existsByUsername(username)) {
			throw new IllegalArgumentException("Tên đăng nhập đã được sử dụng");
		}
		if (accountRepository.existsByEmail(email)) {
			throw new IllegalArgumentException("Email đã được đăng ký");
		}
		if (!form.getPassword().equals(form.getConfirmPassword())) {
			throw new IllegalArgumentException("Mật khẩu nhập lại không khớp");
		}

		return accountRepository.save(new Account(username, email, passwordEncoder.encode(form.getPassword())));
	}
}
