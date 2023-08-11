package hw3.servlet;

import hw3.model.Student;
import hw3.repositories.StudentsRepository;
import hw3.service.StudentsRepositoryImpl;
import lombok.NoArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudents")
@NoArgsConstructor
public class findStudents extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        StudentsRepository studentsRepository = new StudentsRepositoryImpl();

        try {
            String studentName = request.getParameter("studentName");

            List<Student> studentList = studentsRepository.findStudent(studentName);

            request.setAttribute("studentList", studentList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("findStudents.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            throw new RuntimeException("Find Student Exception");
        }
    }
}
