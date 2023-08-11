package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.dto.TeacherResponse;
import org.example.exception.CourseNotFoundException;
import org.example.exception.TeacherNotFoundException;
import org.example.service.CourseService;
import org.example.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@Tag(name = "FindTeachers controller", description = "Service for find Teachers")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequestMapping("/teachers")
public class FindTeacherRESTController {

    TeacherService teacherService;
    CourseService courseService;

    /**
     * find teachers by course
     */
    @Operation(summary = "Find teachers by course")
    @GetMapping(value = "/{course-name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<TeacherResponse> getTeachersByCourse(@PathVariable("course-name")String courseName)
        throws CourseNotFoundException, TeacherNotFoundException{
        courseService.optionalCourse(courseName);
        return ok()
                .body(TeacherResponse.builder()
                        .data(teacherService.findTeacherByCourseDto(courseName))
                        .build());
    }

}
