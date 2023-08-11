package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.service;

import org.example.dto.StudentDto;
import org.example.exception.StudentNotFoundException;

import java.util.List;

/**
 * Поиск всех студентов на курсе
 */
public interface StudentService {
    List<StudentDto> findStudentByCourseDto(String courseName) throws StudentNotFoundException;
}
