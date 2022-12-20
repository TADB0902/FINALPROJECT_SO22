package service;

import dao.ApproveTopicDAO;
import dao.IDAOApproveTopic;
import entity.TopicOfStudent;
import model.TopicOfStudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ApproveTopicService implements IServiceApproveTopic {
    IDAOApproveTopic approveTopicDAO = new ApproveTopicDAO();

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TopicOfStudent topicOfStudent = new TopicOfStudent();
        int id = Integer.parseInt(request.getParameter("id"));
        TopicOfStudentModel topicOfStudentModel = approveTopicDAO.get(id);

        topicOfStudentModel.setStatus(request.getParameter("status"));
        topicOfStudent.setStatus(topicOfStudentModel.getStatus());

        approveTopicDAO.update(topicOfStudent);
        response.sendRedirect("../browse_project");
    }
    public List<TopicOfStudentModel> getTopicOfStudent(String faculty){return approveTopicDAO.getAll(faculty);}
}