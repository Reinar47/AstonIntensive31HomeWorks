package org.example.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.converter.Converter;
import org.example.dto.TeacherDto;
import org.example.model.Teacher;
import org.example.repositories.TeachersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TeacherServiceImpl implements TeacherService {

    TeachersRepository teachersRepository;
    Converter<Teacher,TeacherDto> converter;

   private List<Teacher> findTeacherByCourse(String courseName) {
       Optional<List<Teacher>> teachers = teachersRepository.findTeacher(courseName);

       return teachers.orElseGet(ArrayList::new);
    }

    @Override

    @Transactional
    public List<TeacherDto> findTeacherByCourseDto(String courseName) {

        return converter.toDtoList(findTeacherByCourse(courseName));
    }
}
