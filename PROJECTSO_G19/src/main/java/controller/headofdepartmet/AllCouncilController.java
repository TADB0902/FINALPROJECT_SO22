package controller.headofdepartmet;

import model.CouncilModel;
import model.UserModel;
import service.CouncilService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/truongbomon/council")
public class AllCouncilController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        CouncilService councilService = new CouncilService();
        List<CouncilModel> councilModelList = councilService.ListCouncil(userModel.getFaculty());
        request.setAttribute("action", "list");
        request.setAttribute("councilList", councilModelList);
        request.getRequestDispatcher("../views/headofdepartment/quanlyhoidong.jsp").forward(request, response);;
    }
}
