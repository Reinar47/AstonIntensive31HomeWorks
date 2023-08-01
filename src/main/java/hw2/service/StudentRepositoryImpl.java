package hw2.service;

import hw2.Querys.DBQueryStudent;
import hw2.Querys.DBQueryStudentImpl;
import hw2.Utils.DBResult;
import hw2.Utils.DBResultImpl;

import hw2.Utils.PrintResult;
import hw2.Utils.PrintResultStudent;
import hw2.repositories.StudentRepository;

import java.sql.ResultSet;

public class StudentRepositoryImpl implements StudentRepository {
    DBResult dbResult = new DBResultImpl();
    DBQueryStudent dbQueryStudent = new DBQueryStudentImpl();
    PrintResult printResult = new PrintResultStudent();
    @Override
    public void findStudentByCourse(String courseName) {
        ResultSet result = dbResult.getResultSet(dbQueryStudent.findStudentByCourseQuery(courseName));
        printResult.printResult(result);
    }

    @Override
    public void findStudentByTeacher(String teacherName) {
        ResultSet result = dbResult.getResultSet(dbQueryStudent.findStudentByTeacherQuery(teacherName));
        printResult.printResult(result);
    }


}
