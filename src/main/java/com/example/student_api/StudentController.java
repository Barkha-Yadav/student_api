package com.example.student_api;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {

    private final HashMap<Integer,Student> students;

    public StudentController(){
        this.students = new HashMap<>();
        students.put(1,new Student("abhinav",21,"Computer Science"));
        students.put(2,new Student("anjali",19,"Mathematics"));
        students.put(3,new Student("rahul",22,"Psycology"));
    }

    @GetMapping("/")
    public String homePage(){
        return "Hello! welcome to my API.. try visiting /hello";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World! I just built my first API.";
    }

    @GetMapping("/students")
    public HashMap<Integer,Student> getStudents(){
        return students;
    }

//    @GetMapping("/students/{id}")
//    public String getStudentById(@PathVariable Integer id){
//        return students.getOrDefault(id,"Error! student NOT found 😫");
//    // the error here was that by "get" this function returns "integer type" and by
//    // "default" the method returns "String type" so we need method type "Object"            which allows you to return multiple types in a single function
//    }

    @GetMapping("/students/{id}")
    public Object getStudentById(@PathVariable Integer id){
        if(students.containsKey(id)){
            return students.get(id);
        }
        else{
            return "Error! student NOT found 😫";
        }
    }

//    @PostMapping("/students")
//    public String addStudent(@RequestBody String newStudentName){
//        int newId = students.size()+1;
//
//        students.put(newId,newStudentName);
//        return "Success! added "+newStudentName+" to the database with ID: "+newId;
//    }

    @PostMapping("/students/advanced")
    public String addStudent(@RequestBody Student newStudent){
        int newId = students.size()+1;

        students.put(newId,newStudent);
        return "New student named: "+newStudent.getName()+" who is persuing course: "+newStudent.getCourse();
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        if(students.containsKey(id)){
            String removeName = students.get(id).getName();
            students.remove(id);
            return "Delete! successfully "+removeName+" from the database 😁";
        }
        else{
            return "Can't delete student with ID: "+id+" doesn't exist 😭";
        }
    }

    @PutMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id, @RequestBody Student updateStudent){
        if(students.containsKey(id)){
            students.put(id, updateStudent);
            return "Updated student: "+id+" with the student: "+updateStudent.getName();
        }
        else{
            return "Can not update. The student with id: "+id+" does not exist! 😕";
        }
    }
}
