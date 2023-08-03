package hw2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    String studentName;

    @Override
    public String toString() {
        return "StudentName : " + studentName;
    }
}
