package hw2.repositories;

import hw2.model.Course;
import hw2.model.Student;

public interface TeacherRepository {
    void findTeacherByCourse(String courseName);
    void findTeacherByStudent(String studentName);
}
