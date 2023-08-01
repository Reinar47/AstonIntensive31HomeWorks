package hw2.service;

import hw2.Querys.DBQueryTeacher;
import hw2.Querys.DBQueryTeacherImpl;
import hw2.Utils.*;
import hw2.repositories.TeacherRepository;

import java.sql.ResultSet;

public class TeacherRepositoryImpl implements TeacherRepository {

    DBResult dbResult = new DBResultImpl();;
    DBQueryTeacher dbQueryTeacher = new DBQueryTeacherImpl();
    PrintResult printResult = new PrintResultTeacher();
    @Override
    public void findTeacherByCourse(String courseName) {
        ResultSet result = dbResult.getResultSet(dbQueryTeacher.findTeacherByCourseQuery(courseName));
        printResult.printResult(result);
    }

    @Override
    public void findTeacherByStudent(String studentName) {
        ResultSet result = dbResult.getResultSet(dbQueryTeacher.findTeacherByStudentQuery(studentName));
        printResult.printResult(result);
    }
}
