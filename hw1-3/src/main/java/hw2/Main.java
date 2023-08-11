package hw2;

import hw2.repositories.CourseRepository;
import hw2.repositories.StudentRepository;
import hw2.service.CourseRepositoryImpl;
import hw2.service.StudentRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepositoryImpl();
        StudentRepository studentRepository = new StudentRepositoryImpl();

 //       courseRepository.findCourseByTeacher("Василий Петрович");
 //       courseRepository.findCourseByStudent("Вася");

        studentRepository.findStudentByCourse("Programming");



    }
}
