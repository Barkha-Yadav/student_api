package com.example.student_api;

// these are the new imports for the ORM logic
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

// Tells Hibernate: "Make the database table out of this class"
@Entity
public class Student {
    @Id // tells hibernate: "this is the primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells postgres: autoincrement this ID for me
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

//    @Min(value = 1, message = "Age must be greater than 0")
    @Positive(message = "Age must be greater than 0")
    private Integer age;

    @NotBlank(message = "Course name is required")
    @Size(min = 2, max = 50, message = "Course name must be between 2 and 50 characters")
    private String course;

    @NotBlank(message = "Email can't be empty")
    @Email(message = "Please provide a valid email address")
    private String email;

    // default constructor required by the JPA
    // JPA is Java/Jakarta Persistent API
    public Student(){}

    // constructor without ID - since database creates the ID for us automatically
    public Student(String name, Integer age, String course, String email){
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
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

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
}
