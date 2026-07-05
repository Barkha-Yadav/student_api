package com.example.student_api;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    // You don't have to write a single line of code here!
    // By extending JpaRepository, Spring automatically give you the methods like:
    // save(), findAll(), findById(), deleteById()
}
