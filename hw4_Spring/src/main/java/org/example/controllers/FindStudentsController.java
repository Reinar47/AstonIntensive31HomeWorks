package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.StudentDto;
import org.example.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/findStudents")
public class FindStudentsController {

    final StudentServiceImpl studentService;
    final MainController mainController;

    @GetMapping
    public String getStudentPage(Model model) {
        List<StudentDto> students = studentService.findStudentByCourseDto(mainController.getTargetCourse());

        model.addAttribute("studentList", students);

        return "/templates/findStudents";
    }

}
