package hw2.repositories;

public interface StudentRepository {
    void findStudentByCourse(String courseName);
    void findStudentByTeacher(String teacherName);
}
