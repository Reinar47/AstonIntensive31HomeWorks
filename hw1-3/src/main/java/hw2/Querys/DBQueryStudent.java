package hw2.Querys;

public interface DBQueryStudent {
    String findStudentByCourseQuery(String courseName);

    String findStudentByTeacherQuery(String teacherName);
}
