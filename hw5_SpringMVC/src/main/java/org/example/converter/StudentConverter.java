package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.converter;

import org.example.dto.StudentDto;
import org.example.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter extends Converter<Student, StudentDto>{
    @Override
    public StudentDto to(Student student) {
        if (student == null) {
            return null;
        }

        return StudentDto.builder()
                .firstName(student.getFirstName())
                .LastName(student.getLastName())
                .isStudent(student.isStudent() ? "yes" : "no")
                .build();
    }

    @Override
    public Student from(StudentDto studentDto) {
        if (studentDto == null) {
            return null;
        }

        return Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .isStudent(studentDto.getIsStudent().equals("yes") ? true : false)
                .build();
    }
}
