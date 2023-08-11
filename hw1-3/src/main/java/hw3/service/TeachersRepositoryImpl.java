package hw3.service;

import hw3.model.Teacher;
import hw3.repositories.TeachersRepository;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

@NoArgsConstructor
public class TeachersRepositoryImpl implements TeachersRepository {

    Configuration configuration = new Configuration();

    private static final String SQL_FIND_TEACHERS = "select * from teacher\n" +
            "join teacher_course tc on teacher.id = tc.teacher_id\n" +
            "join course c on c.course_id = tc.course_id" +
            " where c.course_name = :courseName";

    @Override
    public List<Teacher> findTeacher(String courseName) {

        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            List<Teacher> result = session
                    .createNativeQuery(SQL_FIND_TEACHERS, Teacher.class)
                    .setParameter("courseName", courseName)
                    .list();
            transaction.commit();
            session.close();

            return result;

        }
    }


}
