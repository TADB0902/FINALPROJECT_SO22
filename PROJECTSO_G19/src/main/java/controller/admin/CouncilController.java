package controller.admin;

import model.CouncilModel;
import model.TopicOfStudentModel;
import service.CouncilService;
import service.TopicOfStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/council")
public class CouncilController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CouncilService councilService = new CouncilService();
        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();

        List<CouncilModel> councilModelList = councilService.ListCouncil();
        List<TopicOfStudentModel> topicOfTeacherModels = topicOfStudentService.GetListByStatusArgument("No", "Approved");

        if(request.getParameter("message") != null){
            request.setAttribute("message", request.getParameter("message"));
        }

        request.setAttribute("action", "create");
        request.setAttribute("project", topicOfTeacherModels);
        request.setAttribute("listcouncil", councilModelList);
        request.getRequestDispatcher("../views/admin/quanlyhoidong.jsp").forward(request, response);;
    }
}
