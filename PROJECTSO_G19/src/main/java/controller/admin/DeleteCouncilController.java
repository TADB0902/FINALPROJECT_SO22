package controller.admin;

import service.CouncilService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/council/delete")
public class DeleteCouncilController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idTopic= Integer.parseInt(request.getParameter("idTopic"));
        CouncilService councilService = new CouncilService();
        councilService.delete(id,idTopic);
        response.sendRedirect("../council?message=delete");
    }
}
