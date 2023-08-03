package hw2.Querys;

public class DBQueryCourseImpl implements DBQueryCourse {
    @Override
    public String findCourseByStudentQuery(String studentName) {
        return "select course_name from course\n" +
                "join student_course sc on course.course_id = sc.course_id\n" +
                "join student s on s.student_id = sc.student_id\n" +
                "where student_name = " + "'" + studentName + "'" + ";";
    }

    @Override
    public String findCourseByTeacherQuery(String teacherName) {
        return "select course_name from course\n" +
                "join teacher t on t.teacher_id = course.teacher_id\n" +
                "where teacher_name = " + "'" + teacherName + "'" + ";";
    }
}
