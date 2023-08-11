package hw2.Utils;

import hw2.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintResultStudent implements PrintResult {
    @Override
    public List<Object> printResult(ResultSet result) {
        try {
            List<Object> students = new ArrayList<>();
            while (result.next()) {
                String name = result.getString("student_name");

                Student student = Student.builder()
                        .studentName(name)
                        .build();
                students.add(student);
            }
            if (students.size() > 0) {
                System.out.println("Вот студент/ы который вы искали:");
                System.out.println(students);
            } else {
                System.out.println("Не найдено ни одного студента");
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException("Exception in method printResult");
        }

    }

}
