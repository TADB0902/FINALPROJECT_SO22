package controller.teachers;

import dao.TopicOfTeacherDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/giangvien/dangki/delete")
public class DeleteSignUpOfTeachersController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        TopicOfTeacherDAO topicOfTeacherDAO = new TopicOfTeacherDAO();
        topicOfTeacherDAO.delete(Integer.parseInt(id));
        response.sendRedirect("../dangki");
    }
}
