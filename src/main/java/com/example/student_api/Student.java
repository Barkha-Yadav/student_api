package com.example.student_api;

// these are the new imports for the ORM logic
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Tells Hibernate: "Make the database table out of this class"
@Entity
public class Student {
    @Id // tells hibernate: "this is the primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells postgres: autoincrement this ID for me
    private Integer id;

    private String name;
    private Integer age;
    private String course;

    // default constructor required by the JPA
    // JPA is Java/Jakarta Persistent API
    public Student(){}

    // constructor without ID - since database creates the ID for us automatically
    public Student(String name, Integer age, String course){
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // -----getters and setters-----
    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }
}
