package org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.converter.Converter;
import org.example.dto.StudentDto;
import org.example.model.Student;
import org.example.repositories.StudentsRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {

    StudentsRepository studentsRepository;
    Converter<Student, StudentDto> converter;


    private List<Student> findStudentByCourse(String courseName) {
        Optional<List<Student>> students = studentsRepository.findStudent(courseName);

        return students.orElseGet(ArrayList::new);
    }

    @Override
    @Transactional
    public List<StudentDto> findStudentByCourseDto(String courseName) {

        return converter.toDtoList(findStudentByCourse(courseName));
    }
}
