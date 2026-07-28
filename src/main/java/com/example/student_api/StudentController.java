package com.example.student_api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

// annotations i.e @ act as a sticky note in java
// they give the normal classes in java a superpower - you don't have to write 1000 of lines of code to set up the code
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // all these get, post, put, delete are annotation routing
    // i.r telling the SpringBoot what to do when a specific web browser or the postman hits a specific url
    @GetMapping("/")
    public String homePage(){
        return "Hello! welcome to my API.. try visiting /hello";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! I just built my first API.";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Object getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/email/{email}")
    public ResponseEntity<Student> getByEmail(@PathVariable String email){
        Student foundStudent = studentService.getStudentByEmail(email);

        if(foundStudent != null){
            // returns the student data with a 200 OK status
            return ResponseEntity.ok(foundStudent);
        }
        else{
            // returns absolutely nothing, but sends a 404 not Found status
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/students/enterNew")
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student newStudent){
        studentService.addStudent(newStudent);
        return ResponseEntity.ok("Student saved successfully");
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student updateStudent){
       return studentService.updateStudent(id,updateStudent);
    }

    @PatchMapping("/students/{id}")
    public String patchStudent(@PathVariable Integer id, @RequestBody Student updates){
        return studentService.patchStudent(id,updates);
    }
}

// @RestController (The Front Desk / The Waiter)
//You put this on top of your StudentController class.
//
//What it does: It tells Spring Boot, "This class is the front desk of my API. It is allowed to speak to the internet."
//
//The hidden superpower: Because it has the word Rest in it, it automatically takes whatever your Java methods return (like your HashMap of students) and translates it into JSON format before sending it back to the web browser. Without this, the browser wouldn't understand your Java objects.


// @Autowired (The Invisible Wiring)
//This is arguably the most powerful feature in Spring Boot (conceptually known as Dependency Injection). You used this inside your Controller to bring in the Service.
//
//What it does: Instead of you having to manually write StudentService myService = new StudentService(); to create an object, @Autowired tells Spring Boot: "Hey, I need a StudentService right here. Please go find the one you already created and plug it in for me."
//
//Why it's amazing: It connects your Waiter to your Kitchen automatically. If your Kitchen eventually requires a Database, Spring will automatically wire that up too. It handles the lifecycle of all your objects so you don't have to worry about creating or destroying them.
