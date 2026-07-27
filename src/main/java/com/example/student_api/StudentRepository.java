package com.example.student_api;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    // You don't have to write a single line of code here!
    // By extending JpaRepository, Spring automatically give you the methods like:
    // save(), findAll(), findById(), deleteById()

    Optional<Student> findByEmail(String email);
}
