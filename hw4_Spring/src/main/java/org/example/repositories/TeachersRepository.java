package org.example.repositories;





import org.example.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeachersRepository extends JpaRepository<Teacher,Long> {

    @Query(value = "select teacher from Teacher teacher " +
            "join fetch teacher.courses courses where courses.courseName = :courseName")
    Optional<List<Teacher>> findTeacher(@Param("courseName") String courseName);

}
