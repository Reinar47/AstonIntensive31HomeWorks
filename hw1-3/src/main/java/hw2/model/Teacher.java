package hw2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Teacher {
    String teacherName;

    @Override
    public String toString() {
        return "TeacherName : " + teacherName;
    }
}
