package hw2.repositories;

public interface TeacherRepository {
    void findTeacherByCourse(String courseName);
    void findTeacherByStudent(String studentName);
}
