package org.example.converter;

import org.example.dto.TeacherDto;
import org.example.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherConverter extends Converter<Teacher, TeacherDto> {

    @Override
    public TeacherDto to(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        return TeacherDto.builder()
                .firstName(teacher.getFirstName())
                .LastName(teacher.getLastName())
                .isTeacher(teacher.isTeacher() ? "yes" : "no")
                .build();
    }

    @Override
    public Teacher from(TeacherDto teacherDto) {
        if (teacherDto == null) {
            return null;
        }

        return Teacher.builder()
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .isTeacher(teacherDto.getIsTeacher().equals("yes") ? true : false)
                .build();

    }


}
