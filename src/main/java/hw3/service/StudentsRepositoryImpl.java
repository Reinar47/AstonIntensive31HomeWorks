package hw3.service;

import hw3.model.Student;
import hw3.repositories.StudentsRepository;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

@NoArgsConstructor
public class StudentsRepositoryImpl implements StudentsRepository {

    org.hibernate.cfg.Configuration configuration = new Configuration();
    private static final String SQL_FIND_STUDENTS =
            "select * from student " +
                    "join student_course sc on student.id = sc.student_id\n" +
                    "join course c on c.course_id = sc.course_id"
                    + " where c.course_name = :courseName";

    @Override
    public List<Student> findStudent(String courseName) {
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            List<Student> result = session
                    .createNativeQuery(SQL_FIND_STUDENTS, Student.class)
                    .setParameter("courseName", courseName)
                    .list();
            transaction.commit();
            session.close();

            return result;
        }
    }

}
