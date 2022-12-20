package controller.admin;

import service.IServiceTimeSignUp;
import service.TimeSignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/taotimedangki/delete"})
public class DeleteTimeSignupController extends HttpServlet {
    IServiceTimeSignUp timeSignUpService = new TimeSignUpService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        timeSignUpService.delete(id);
        resp.sendRedirect("../taotimedangki");
    }
}