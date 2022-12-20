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

@WebServlet("/giangvien/dangki")
public class TopicOfTeachersController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();
        List<TopicOfTeacherModel> topicOfTeacherModels =topicOfTeacherService.GetList(userModel.getUsername());
        request.setAttribute("topicOfTeacherDAO", topicOfTeacherModels);
        request.setAttribute("teacher", userModel);
        request.setAttribute("action", "create");
        String message = request.getParameter("message");
        if(message != null){
            request.setAttribute("message", message);
        }
        request.getRequestDispatcher("/views/giangvien/dangkidetai.jsp").forward(request, response);
    }
}
