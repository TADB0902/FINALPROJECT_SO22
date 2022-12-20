package controller.headofdepartmet;

import model.TopicOfStudentModel;
import service.ApproveTopicService;
import service.TopicOfStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/headofdepartment/duyetdetai"})
public class ApproveTopicController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TopicOfStudentModel topicOfStudentModel = new TopicOfStudentModel();
        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();


        int id = Integer.parseInt(req.getParameter("id"));

        topicOfStudentModel = topicOfStudentService.getStudent(id);

        req.setAttribute("topicOfStudentModel", topicOfStudentModel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApproveTopicService approveTopicService = new ApproveTopicService();
        approveTopicService.update(req, resp);
        resp.sendRedirect("../headofdepartment/duyetdetai");
    }
}