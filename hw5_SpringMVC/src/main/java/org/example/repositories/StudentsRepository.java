package org.example.repositories;


import org.example.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {
    @Query(value = "select student from Student student " +
            "join fetch student.courses courses where courses.courseName = :courseName")
    Optional<List<Student>> findStudent(@Param("courseName") String courseName);



}
