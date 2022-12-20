package controller.students;

import model.TopicOfTeacherModel;
import model.TopicOfStudentModel;
import model.UserModel;
import service.TopicOfTeacherService;
import service.TopicOfStudentService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sinhvien/signup/change")
public class ChangeFacultyController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();
        TopicOfStudentModel topicOfStudentModel = topicOfStudentService.Get(userModel.getUsername());


        String faculty =request.getParameter("faculty");
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();
        List<TopicOfTeacherModel> topicOfTeacherModels =topicOfTeacherService.GetListFaculty(faculty);
        request.setAttribute("topicOfTeacherModels", topicOfTeacherModels);
        request.setAttribute("faculty", faculty);
        request.setAttribute("topicOfStudentModel", topicOfStudentModel);
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        System.out.println(topicOfStudentModel);
        request.getRequestDispatcher("/views/sinhvien/dangkidetai.jsp").forward(request, response);
    }
}
