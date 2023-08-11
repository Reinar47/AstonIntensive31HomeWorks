package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.dto.TeacherDto;
import org.example.exception.TeacherNotFoundException;
import org.example.service.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/findTeachers")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FindTeachersController {
    final TeacherServiceImpl teacherService;
    final MainController mainController;

    @GetMapping
    public String getTeachersPage(Model model) throws TeacherNotFoundException {
        List<TeacherDto> teachers = teacherService.findTeacherByCourseDto(mainController.getTargetCourse());

        model.addAttribute("teachersList", teachers);

        return "/templates/findTeachers";

    }
}
