package hw3.repositories;



import hw3.model.Teacher;

import java.util.List;

public interface TeachersRepository {
    List<Teacher> findTeacher(String courseName);

}
