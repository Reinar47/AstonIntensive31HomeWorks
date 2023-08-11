package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.converter.Converter;
import org.example.dto.StudentDto;
import org.example.exception.StudentNotFoundException;
import org.example.model.Student;
import org.example.repositories.StudentsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {

    StudentsRepository studentsRepository;
    Converter<Student, StudentDto> converter;


    private List<Student> findStudentByCourse(String courseName) throws StudentNotFoundException {
        Optional<List<Student>> students = studentsRepository.findStudent(courseName);
        if (students.isPresent()) {
            return students.get();
        } else {
            throw new StudentNotFoundException();
        }
    }

    @Override
    @Transactional
    public List<StudentDto> findStudentByCourseDto(String courseName) throws StudentNotFoundException {

        return converter.toDtoList(findStudentByCourse(courseName));
    }

}
