package hw2.Querys;

public class DBQueryStudentImpl implements DBQueryStudent {

    @Override
    public String findStudentByCourseQuery(String courseName) {
        return "select student_name from student\n" +
                "    join student_course sc on student.student_id = sc.student_id\n" +
                "    join course c on c.course_id = sc.course_id\n" +
                "    where course_name = " + "'" + courseName + "'" + ";";
    }

    @Override
    public String findStudentByTeacherQuery(String teacherName) {
        return "select student_name from student\n" +
                "join student_course sc on student.student_id = sc.student_id\n" +
                "join course c on c.course_id = sc.course_id\n" +
                "join teacher t on t.teacher_id = c.teacher_id\n" +
                "where t.teacher_name = " + "'" + teacherName + "'" + ";";
    }
}
