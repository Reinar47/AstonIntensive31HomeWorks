package hw2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Course {

    String courseName;

    @Override
    public String toString() {
        return "CourseName : " + courseName;
    }
}
