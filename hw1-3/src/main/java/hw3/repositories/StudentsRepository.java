package hw3.repositories;


import hw3.model.Student;

import java.util.List;

public interface StudentsRepository {
    List<Student> findStudent(String courseName);

}
