package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.service;

import org.example.exception.CourseNotFoundException;
import org.example.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseService{

    Optional<Course> optionalCourse(String courseName) throws CourseNotFoundException;
}
