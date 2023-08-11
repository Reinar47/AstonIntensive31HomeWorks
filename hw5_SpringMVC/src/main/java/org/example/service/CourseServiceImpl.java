package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.exception.CourseNotFoundException;
import org.example.model.Course;
import org.example.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    @Override
    @Transactional
    public Optional<Course> optionalCourse(String courseName) throws CourseNotFoundException {

        return Optional.ofNullable(courseRepository.findAllByCourseName(courseName)
                .orElseThrow(() -> new CourseNotFoundException()));

    }
}
