package hw2.Querys;

public interface DBQueryTeacher {

    String findTeacherByCourseQuery(String courseName);
    String findTeacherByStudentQuery(String studentName);

}
