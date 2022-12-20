package controller.headofdepartmet;

import model.CouncilModel;
import service.CouncilService;
import service.CouncilMemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/headofdepartment/council/deleteAll")
public class DelCouncilMemsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        CouncilMemberService councilMemberService = new CouncilMemberService();
        councilMemberService.deleteAll(idCouncil);//xóa tất cả thành viên
        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(idCouncil);
        councilModel.setStatus("Unassigned");
        councilModel.setLeader(null);
        councilService.update(councilModel);
        response.sendRedirect("../council");
    }
}
