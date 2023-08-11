package org.example.service;

import org.example.dto.StudentDto;

import java.util.List;

/**
 * Поиск всех студентов на курсе
 */
public interface StudentService {
    List<StudentDto> findStudentByCourseDto(String courseName);
}
