package controller.teachers;

import model.TopicOfTeacherModel;
import model.UserModel;
import service.TopicOfTeacherService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/giangvien/dangki/update")
public class EditSignUpTopicOfTeacherController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        int id = Integer.parseInt(request.getParameter("id"));
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();
        TopicOfTeacherModel topicOfTeacherModel = topicOfTeacherService.getUser(id);
        List<TopicOfTeacherModel> topicOfTeacherModels =topicOfTeacherService.GetList(userModel.getUsername());
        request.setAttribute("topicOfTeacherDAO", topicOfTeacherModels);
        request.setAttribute("topicOfTeacherModel", topicOfTeacherModel);
        request.setAttribute("action", "update");
        request.setAttribute("teachers", userModel);
        request.getRequestDispatcher("/views/giangvien/dangkidetai.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String topic = request.getParameter("topic");
        String requestParameter = request.getParameter("request");
        String target = request.getParameter("target");
        int id = Integer.parseInt(request.getParameter("id"));
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();
        TopicOfTeacherModel topicOfTeacherModel = topicOfTeacherService.getUser(id);
        topicOfTeacherModel.setTopic(topic);
        topicOfTeacherModel.setRequest(requestParameter);
        topicOfTeacherModel.setTarget(target);
        topicOfTeacherService.update(topicOfTeacherModel);
        response.sendRedirect("../dangki");
    }
}
