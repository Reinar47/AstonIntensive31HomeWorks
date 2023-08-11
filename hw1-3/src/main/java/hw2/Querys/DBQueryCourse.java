package hw2.Querys;

public interface DBQueryCourse {
    String findCourseByStudentQuery(String studentName);

    String findCourseByTeacherQuery(String teacherName);
}
