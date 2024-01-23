package com.example.Spring.Security.Demo;

import com.example.Spring.Security.Demo.Model.UserData;
import com.example.Spring.Security.Demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		UserData userData = new UserData("Pranav", passwordEncoder.encode("Admin"), "ROLE_ADMIN");

		UserData userData1 = new UserData("Shaban", passwordEncoder.encode("NormalUser"), "ROLE_USER");

		userRepository.saveAll(List.of(userData, userData1));
	}
}
