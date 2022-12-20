package controller.admin;

import model.TimeSignupModel;
import service.TimeSignUpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/taotimedangki"})
public class TimeSignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TimeSignupController(){super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        TimeSignUpService registrationPeriodService = new TimeSignUpService();
        List<TimeSignupModel> timeSignupModelList = registrationPeriodService.getAll();
        request.setAttribute("registrationPeriodModelList", timeSignupModelList);
        request.getRequestDispatcher("../views/admin/taotimedangki.jsp").forward(request, response);
    }
}
