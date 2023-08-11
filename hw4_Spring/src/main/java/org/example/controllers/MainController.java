package org.example.controllers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.dto.CourseDto;
import org.example.service.StudentServiceImpl;
import org.example.service.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainController {

    final StudentServiceImpl studentService;
    final TeacherServiceImpl teacherService;

    String targetCourse;

    @PostMapping
    public String findStudents(CourseDto courseDto) {

        targetCourse = courseDto.getCourseName();

        return "redirect:/findStudents";
    }

    @PostMapping
    public String findTeachers(CourseDto courseDto) {

        targetCourse = courseDto.getCourseName();

        return "redirect:/findTeachers";
    }


}
