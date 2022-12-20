package controller.admin;

import model.TimeSignupModel;
import service.TimeSignUpService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/taotimedangki")
public class CreateTimeSignup extends HttpServlet {
    TimeSignUpService timeSignUpService = new TimeSignUpService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TimeSignupModel timeSignupModel = new TimeSignupModel();
        String start = req.getParameter("startday");
        String end = req.getParameter("endday");
        try {
            Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
            Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
            timeSignupModel.setStartday(startdate);
            timeSignupModel.setEndday(enddate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String username = SessionUtil.getInstance().getValue(req, "USERMODEL").toString();
        System.out.println(username);
        timeSignupModel.setRole(req.getParameter("role"));
        timeSignUpService.create(timeSignupModel);
        resp.sendRedirect("../admin/taotimedangky");
    }
}