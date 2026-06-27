package com.example.student_api;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StudentService {
    private final HashMap<Integer,Student> students;

    public HashMap<Integer,Student> getAllStudents(){
        return students;
    }

    public StudentService(){
        this.students = new HashMap<>();
        students.put(1, new Student("John",21,"Computer Science"));
        students.put(2, new Student("Anny",24,"Artificial Intelligence"));
        students.put(3, new Student("Harry",20,"Iot"));
    }

    public Object getStudentById(Integer id){
        if(students.containsKey(id)){
            return students.get(id);
        }
        else{
            return "the student with id: "+id+" does not exists!! 😁";
        }
    }

    public String addStudent(Student newStudent){
        int newId = students.size()+1;
        students.put(newId, newStudent);
        return "The student: "+newStudent.getName()+" is added to id: "+newId+" 😍";
    }

    public String deleteStudent(Integer id){
        if(students.containsKey(id)){
            String remName = students.get(id).getName();
            students.remove(id);
            return "Student with id: "+id+" and name: "+remName+" id removed!! 😭";
        }
        else{
            return "student with id: "+id+" does not exists!! 😏";
        }
    }

    public String updateStudent(Integer id, Student updateDetails){
        if(students.containsKey(id)){
            students.put(id,updateDetails);
            return "The details of Student with id: "+id+" and name: "+updateDetails.getName()+" are updated!! 😉";
        }
        else{
            return "Can not update id: "+id+" No such student exists in our record!!🫩";
        }
    }
}

// @Service (The Kitchen / The Brains)
//You put this on top of your StudentService class.
//
//What it does: It tells Spring Boot, "This class doesn't talk to the internet. This class holds my business logic, handles the heavy calculations, and manages my database."
//
//By tagging it as a @Service, you are officially registering this class into Spring's master list of "important tools" that can be used elsewhere in the application.
