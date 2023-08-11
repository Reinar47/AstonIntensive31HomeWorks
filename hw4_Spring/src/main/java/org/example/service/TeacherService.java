package org.example.service;

import org.example.dto.TeacherDto;

import java.util.List;

/**
 * Поиск учителей на курсе
 */
public interface TeacherService {
    List<TeacherDto> findTeacherByCourseDto(String courseName);
}
