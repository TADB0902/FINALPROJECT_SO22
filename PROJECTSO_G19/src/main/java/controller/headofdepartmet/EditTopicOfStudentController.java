package controller.headofdepartmet;

import model.TopicOfStudentModel;
import service.TopicOfStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/headofdepartment/browse-project/update")
public class EditTopicOfStudentController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();
        TopicOfStudentModel topicOfStudentModel = topicOfStudentService.getStudent(id);
        if(action.equals("Approve")){
            topicOfStudentModel.setStatus("Approved");
        }
        else {
            topicOfStudentModel.setStatus("Not Approve");
        }
        topicOfStudentService.update(topicOfStudentModel);
        response.sendRedirect("../duyetdetai");
    }
}
