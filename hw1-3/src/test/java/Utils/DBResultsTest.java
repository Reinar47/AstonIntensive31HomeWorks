package Utils;


import hw2.Utils.*;

import hw2.model.Course;
import hw2.model.Student;
import hw2.model.Teacher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DBResultsTest {
    DBResult dbResult = new DBResultImpl();
    PrintResult printResultCourse = new PrintResultCourse();
    PrintResult printResultStudent = new PrintResultStudent();
    PrintResult printResultTeacher = new PrintResultTeacher();
    private static final Course TEST_COURSE = Course.builder()
            .courseName("Programming")
            .build();
    private static final Student TEST_STUDENT_1 = Student.builder()

            .studentName("Вася")
            .build();
    private static final Student TEST_STUDENT_2 = Student.builder()
            .studentName("Петя")
            .build();
    private static final Student TEST_STUDENT_3 = Student.builder()
            .studentName("Вова")
            .build();
    private static final Teacher TEST_TEACHER = Teacher.builder()
            .teacherName("Василий Петрович")
            .build();
    private static final List<Object> RESULT_STUDENT_OBJECTS_FROM_DB =
            List.of(TEST_STUDENT_1, TEST_STUDENT_2, TEST_STUDENT_3);


    private static final List<Object> RESULT_TEACHER_OBJECTS_FROM_DB = List.of(TEST_TEACHER);

    private static final List<String> RESULT_COURSE_FROM_DB = List.of("Programming");
    private static final List<Object> RESULT_COURSE_OBJECTS_FROM_DB = List.of(TEST_COURSE);


    final String findCourseByStudent = "select course_name from course\n" +
            "join student_course sc on course.course_id = sc.course_id\n" +
            "join student s on s.student_id = sc.student_id\n" +
            "where student_name = 'Вася';";
    final String findStudentByCourse = "select student_name from student\n" +
            "join student_course sc on student.student_id = sc.student_id\n" +
            "join course c on c.course_id = sc.course_id\n" +
            "where course_name = 'Programming';";
    final String findTeacherByCourse = "select teacher_name from teacher\n" +
            "join course c on teacher.teacher_id = c.teacher_id\n" +
            "where course_name = 'Programming'";


    @Order(1)
    @ParameterizedTest(name = "findCourseByStudent")
    @ValueSource(strings = {findCourseByStudent})
    void getResultSetCourseTest(String query) {
        try {
            ResultSet result = dbResult.getResultSet(query);
            List<String> resultStrings = new ArrayList<>();
            while (result.next()) {
                resultStrings.add(result.getString("course_name"));
            }
            assertEquals(RESULT_COURSE_FROM_DB, resultStrings);
        } catch (SQLException e) {
            throw new RuntimeException("Test getResultSetCourse");
        }
    }

    @Order(2)
    @ParameterizedTest(name = "PrintResultCourseTest")
    @ValueSource(strings = {findCourseByStudent})
    void PrintResultCourseTest(String query) {

        ResultSet result = dbResult.getResultSet(query);
        List<Object> actualResult = printResultCourse.printResult(result);
        assertEquals(RESULT_COURSE_OBJECTS_FROM_DB, actualResult);
    }
    @Order(3)
    @ParameterizedTest(name = "PrintResultStudentTest")
    @ValueSource(strings = {findStudentByCourse})
    void PrintResultStudentTest(String query){
        ResultSet resultSet = dbResult.getResultSet(query);
        List<Object> actualResult = printResultStudent.printResult(resultSet);
        assertEquals(RESULT_STUDENT_OBJECTS_FROM_DB,actualResult);

    }
    @Order(4)
    @ParameterizedTest(name = "PrintResultTeacherTest")
    @ValueSource(strings = {findTeacherByCourse})
    void PrintResultTeacherTest(String query){
        ResultSet resultSet = dbResult.getResultSet(query);
        List<Object> actualResult = printResultTeacher.printResult(resultSet);
        assertEquals(RESULT_TEACHER_OBJECTS_FROM_DB,actualResult);


    }

}