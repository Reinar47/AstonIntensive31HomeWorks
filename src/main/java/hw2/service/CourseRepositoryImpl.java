package hw2.service;

import hw2.Querys.DBQueryCourse;
import hw2.Querys.DBQueryCourseImpl;
import hw2.Utils.DBResult;
import hw2.Utils.DBResultImpl;
import hw2.Utils.PrintResult;
import hw2.Utils.PrintResultCourse;
import hw2.repositories.CourseRepository;

import java.sql.ResultSet;

public class CourseRepositoryImpl implements CourseRepository {
    DBResult dbResult = new DBResultImpl();
    DBQueryCourse dbQueryCourse = new DBQueryCourseImpl();
    PrintResult printResult = new PrintResultCourse();


    @Override
    public void findCourseByStudent(String studentName) {
        ResultSet result = dbResult.getResultSet(dbQueryCourse.findCourseByStudentQuery(studentName));
        printResult.printResult(result);
    }

    @Override
    public void findCourseByTeacher(String teacherName) {
        ResultSet result = dbResult.getResultSet(dbQueryCourse.findCourseByTeacherQuery(teacherName));
        printResult.printResult(result);
    }

}
