package com.example.student_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

}

// @SpringBootApplication (The Engine Starter)
//You will only ever see this once per project, sitting right on top of your main class (StudentApiApplication.java).
//
//What it does: It tells Java, "This isn't a normal Java program; this is a massive Spring Boot web server."
//
//It automatically boots up the internal web server (Tomcat), scans your entire project folder for other annotations, and auto-configures everything you need to run an API. It is the "ON" switch for the entire machine.
