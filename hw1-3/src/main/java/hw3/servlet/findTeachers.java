package hw3.servlet;

import hw3.model.Teacher;
import hw3.repositories.TeachersRepository;
import hw3.service.TeachersRepositoryImpl;
import lombok.NoArgsConstructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findTeachers")
@NoArgsConstructor
public class findTeachers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        TeachersRepository teachersRepository = new TeachersRepositoryImpl();

        try {
            String courseName = request.getParameter("courseName");

            List<Teacher> teacherList = teachersRepository.findTeacher(courseName);

            request.setAttribute("teacherList", teacherList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("findTeachers.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException e) {
            throw new RuntimeException("Find Teachers Exception");
        }
    }
}
