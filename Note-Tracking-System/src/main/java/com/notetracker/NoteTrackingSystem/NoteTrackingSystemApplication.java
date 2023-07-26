package com.notetracker.NoteTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NoteTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteTrackingSystemApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Hello world";
	}
}
