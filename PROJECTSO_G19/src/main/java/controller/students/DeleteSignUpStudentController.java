package controller.students;

import dao.TopicOfStudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sinhvien/dangkitopic/delete")
public class DeleteSignUpStudentController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        topicOfStudentDAO.delete(Integer.parseInt(id));
        response.sendRedirect("../dangkitopic/delete");
    }
}
