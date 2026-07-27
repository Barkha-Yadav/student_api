package com.example.student_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    // 1. The Magic Connection: Wire in new database repository
    @Autowired
    private StudentRepository repository;

    // this Student is the Student class object that we have created
    public List<Student> getAllStudents(){
        // findAll() automatically generates: SELECT * FROM student;
        return repository.findAll();
    }

    public Object getStudentById(Integer id){
        // findById() returns an Optional<Student> (a box that might be empty).
        Optional<Student> student = repository.findById(id);
        if(student.isPresent()){
            return student.get(); // Open the box and get the student
        }
        else{
            return "Error! student NOT found 😡";
        }
    }

    public String addStudent(Student newStudent){
        // save() automatically generates: INSERT INTO student...
        repository.save(newStudent);
        return "New student named: " + newStudent.getName() + " saved to the database!";
    }

    public String deleteStudent(Integer id){
//        Optional<Student> student = repository.findById(id);
//        if(student.isPresent()){
//            Student newStudent = student.get();
//            repository.deleteById(id);
//            return "Student: "+newStudent.getName()+" is deleted";
//        }
//        else{
//            return "student with id: "+id+" does not exists!! 😏";
//        }

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted successfully from the database 🥳";
        } else {
            return "Can not delete student with ID: " + id + " because he/she doesn't exist 😭";
        }
    }

    public String updateStudent(Integer id, Student updateDetails){
        if(repository.existsById(id)){
            updateDetails.setId(id);
            repository.save(updateDetails);
            return "Updated student: " + id + " with the student: " + updateDetails.getName();
        }
        else{
            return "Can not update id: "+id+" No such student exists in our record!!🫩";
        }
    }

    public String patchStudent(Integer id, Student updates){
        Optional<Student> optionalStudent = repository.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            if(updates.getName() != null){
                existingStudent.setName(updates.getName());
            }
            if(updates.getAge() != null){
                existingStudent.setAge(updates.getAge());
            }
            if(updates.getCourse() != null){
                existingStudent.setCourse(updates.getCourse());
            }
            if(updates.getEmail() != null){
                existingStudent.setEmail(updates.getEmail());
            }
            repository.save(existingStudent);
            return "Successfully patched student ID: "+id;
        }
        else{
            return "Can not patch! Student with ID: "+id+" Not Found!!🫩";
        }
    }

    public Student getStudentByEmail(String email){
        return repository.findByEmail(email).orElse(null);
    }
}

// @Service (The Kitchen / The Brains)
//You put this on top of your StudentService class.
//
//What it does: It tells Spring Boot, "This class doesn't talk to the internet. This class holds my business logic, handles the heavy calculations, and manages my database."
//
//By tagging it as a @Service, you are officially registering this class into Spring's master list of "important tools" that can be used elsewhere in the application.
