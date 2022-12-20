package controller.admin;

import model.TimeSignupModel;
import service.TimeSignUpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet(urlPatterns = {"/admin/registration_period/edit"})
public class EditTimeSignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TimeSignupModel timeSignupModel = new TimeSignupModel();

        try {
            String start = req.getParameter("startday");
            String end = req.getParameter("endday");
            String ID = req.getParameter("id");
            try {
                int Id = Integer.parseInt(ID);
                Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(start);
                Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(end);
                timeSignupModel.setId(Id);
                timeSignupModel.setStartday(startdate);
                timeSignupModel.setEndday(enddate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            timeSignupModel.setRole(req.getParameter("role"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("timsignupModels", timeSignupModel);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TimeSignUpService timeSignUpService = new TimeSignUpService();
        timeSignUpService.update(req, resp);
        resp.sendRedirect("./admin/taotimedangki");
    }
}