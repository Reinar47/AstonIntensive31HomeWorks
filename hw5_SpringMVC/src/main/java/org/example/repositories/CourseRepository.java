package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.repositories;

import org.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository  extends JpaRepository<Course,Long> {
    Optional<Course> findAllByCourseName(String courseName);
}