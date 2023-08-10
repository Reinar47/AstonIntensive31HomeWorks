package hw2.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Builder
public class Course {

    String courseName;

    @Override
    public String toString() {
        return "CourseName : " + courseName;
    }
}
