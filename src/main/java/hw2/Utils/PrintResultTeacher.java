package hw2.Utils;

import hw2.model.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintResultTeacher implements PrintResult {
    @Override
    public List<Object> printResult(ResultSet result) {
        try {
            List<Object> teachers = new ArrayList<>();
            while (result.next()) {
                Teacher teacher = Teacher.builder()
                        .teacherName(result.getString("teacher_name"))
                        .build();

                teachers.add(teacher);
            }
            if (teachers.size() > 0) {
                System.out.println("Вот учитель который вы искали:");
                System.out.println(teachers);
            } else {
                System.out.println("Не найдено ни одного учителя");
            }
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException("Exception in method printResult");
        }
    }
}
