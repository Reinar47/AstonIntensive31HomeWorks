package hw2.Querys;

public class DBQueryTeacherImpl implements DBQueryTeacher {
    @Override
    public String findTeacherByCourseQuery(String courseName) {
        return "select teacher_name from teacher\n" +
                "join course c on teacher.teacher_id = c.teacher_id\n" +
                "where course_name =" + "'" + courseName + "'" + ";";
    }

    @Override
    public String findTeacherByStudentQuery(String studentName) {
        return "select teacher_name from teacher\n" +
                "join course c on teacher.teacher_id = c.teacher_id\n" +
                "join student_course sc on c.course_id = sc.course_id\n" +
                "join student s on s.student_id = sc.student_id\n" +
                "where student_name =" + "'" + studentName + "'" + ";";
    }
}
