package controller.headofdepartmet;

import model.CouncilModel;
import model.CouncilMembersModel;
import model.UserModel;
import service.CouncilService;
import service.CouncilMemberService;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/headofdepartment/council/create")
public class CreateCounciMemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        String message = request.getParameter("message");
        int id;
        if(request.getParameter("id") != null){
            id =  Integer.parseInt(request.getParameter("id"));
        }
        else
        {
            id =  Integer.parseInt(request.getParameter("idCouncil"));
        }
        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(id);
        String idTeacher = councilModel.getTopicOfStudent().getTopicOfTeacher().getUser().getUsername();
        CouncilMemberService councilMemberService = new CouncilMemberService();
        String action =request.getParameter("action");
        List<CouncilMembersModel> councilMembersModels;
        councilMembersModels = councilMemberService.getList(id);

        UserService userService = new UserService();
        List<UserModel> teacherList = userService.getTeacher(idTeacher, userModel.getFaculty());
        if(action != null ){
            String search =request.getParameter("search");
            teacherList = userService.getListSearch(idTeacher, search, userModel.getFaculty());
        }
        else {
            teacherList = userService.getTeacher(idTeacher, userModel.getFaculty());
        }

        int number = councilMemberService.count(id);

        if(councilModel.getLeader() != null)
        {
            number = number + 1;
        }
        request.setAttribute("message",message);
        request.setAttribute("memberCouncilModels", councilMembersModels);
        request.setAttribute("number",number);
        request.setAttribute("councilModel", councilModel);
        request.setAttribute("action", "create");
        request.setAttribute("teacherList", teacherList);
        request.getRequestDispatcher("../../views/truongbomon/quanlyhoidong.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
