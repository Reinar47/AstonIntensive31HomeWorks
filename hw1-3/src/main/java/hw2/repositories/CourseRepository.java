package hw2.repositories;

public interface CourseRepository {
    void findCourseByStudent(String studentName);

    void findCourseByTeacher(String teacherName);
}
