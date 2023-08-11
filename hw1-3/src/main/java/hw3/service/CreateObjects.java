package hw3.service;

import hw3.model.Course;
import hw3.model.Student;
import hw3.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateObjects {
    public static void main(String[] args) {



        try (Session session = new Configuration().configure().buildSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            Teacher teacher1 = Teacher.builder()
                    .firstName("Nikolay")
                    .lastName("Petrovich")
                    .isTeacher(true)
                    .build();
            Teacher teacher2 = Teacher.builder()
                    .firstName("Igor")
                    .lastName("Vasiltvich")
                    .isTeacher(true)
                    .build();
            Teacher teacher3 = Teacher.builder()
                    .firstName("Feodor")
                    .lastName("Ivanovich")
                    .isTeacher(true)
                    .build();

            Student student1 = Student.builder()
                    .firstName("Vasaof")
                    .lastName("Pupkinof")
                    .isStudent(true)
                    .build();
            Student student2 = Student.builder()
                    .firstName("Artem")
                    .lastName("Anisimov")
                    .isStudent(true)
                    .build();
            Student student3 = Student.builder()
                    .firstName("Vera")
                    .lastName("Petrova")
                    .isStudent(true)
                    .build();

            Course course1 = Course.builder()
                    .courseName("Math")
                    .build();
            Course course2 = Course.builder()
                    .courseName("Programming")
                    .build();

            course1.getStudents().add(student1);
            course1.getStudents().add(student2);
            course1.getTeachers().add(teacher2);

            course2.getTeachers().add(teacher1);
            course2.getStudents().add(student3);

            session.save(course1);
            session.save(course2);

            transaction.commit();

            session.close();
        }
    }
}
