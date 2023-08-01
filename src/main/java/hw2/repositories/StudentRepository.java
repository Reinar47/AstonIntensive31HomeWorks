package hw2.repositories;

import hw2.model.Course;
import hw2.model.Teacher;

public interface StudentRepository {
    void findStudentByCourse(String courseName);
    void findStudentByTeacher(String teacherName);
}
