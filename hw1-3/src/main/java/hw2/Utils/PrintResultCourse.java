package hw2.Utils;

import hw2.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintResultCourse implements PrintResult {
    @Override
    public List<Object> printResult(ResultSet result) {
        try {
            List<Object> courses = new ArrayList<>();

            while (result.next()) {
                Course course = Course.builder()
                        .courseName(result.getString("course_name"))
                        .build();
                courses.add(course);
            }
            if (courses.size() > 0) {
                System.out.println("Вот курс который вы искали:");
                System.out.println(courses);
            } else {
                System.out.println("Не найдено ни одного курса");
            }

            return courses;
        } catch (SQLException e) {
            throw new RuntimeException("Exception in method printResult");
        }
    }

}
