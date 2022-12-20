package controller.headofdepartmet;

import model.TopicOfStudentModel;
import model.UserModel;
import service.ApproveTopicService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/truongbomon/browse-project"})
public class AllTopicOfStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AllTopicOfStudentController(){super();}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        ApproveTopicService approveTopicService = new ApproveTopicService();
        List<TopicOfStudentModel> topicOfStudentModelList = approveTopicService.getTopicOfStudent(userModel.getFaculty());
        request.setAttribute("topicOfStudentModelList", topicOfStudentModelList);
        request.getRequestDispatcher("../views/headofdepartment/censor-project.jsp").forward(request, response);
    }
}
