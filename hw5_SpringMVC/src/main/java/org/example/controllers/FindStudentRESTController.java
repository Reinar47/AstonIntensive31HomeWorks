package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.dto.StudentResponse;
import org.example.exception.CourseNotFoundException;
import org.example.exception.StudentNotFoundException;
import org.example.service.CourseService;
import org.example.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Tag(name = "FindStudent controller", description = "Service for find Students")
@RequestMapping("/students")
public class FindStudentRESTController {

    StudentServiceImpl studentService;
    CourseService courseService;

    /**
     * find students by course
     */
    @Operation(summary = "Find students by course")
    @GetMapping(value = "/{course-name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<StudentResponse> getStudentsByCourse(@PathVariable("course-name") String courseName)
            throws CourseNotFoundException, StudentNotFoundException {

        courseService.optionalCourse(courseName);

        return ok()
                .body(StudentResponse.builder()
                        .data(studentService.findStudentByCourseDto(courseName))
                        .build());
    }

}
