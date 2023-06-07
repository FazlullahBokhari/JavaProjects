package com.example.securityjpa4.demo.securityjpa4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("faiz","$2a$10$iOpImJO0madmaGppi0aUA.MAQ/UZNKizhbbaZiQIMenFoA7J2b.TS",true,"admin:student");
		User user1 = new User("deen","$2a$10$iOpImJO0madmaGppi0aUA.MAQ/UZNKizhbbaZiQIMenFoA7J2b.TS",true,"student");
		User user2 = new User("fazlu","$2a$10$iOpImJO0madmaGppi0aUA.MAQ/UZNKizhbbaZiQIMenFoA7J2b.TS",true,"admin:student");

		userRepository.save(user);
		userRepository.save(user1);
		userRepository.save(user2);
	}
}
