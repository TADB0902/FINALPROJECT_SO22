package service;

import dao.TimeSignupDAO;
import entity.TimeSignup;
import model.TimeSignupModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeSignUpService implements IServiceTimeSignUp {
    TimeSignupDAO timeSignupDAO = new TimeSignupDAO();

    @Override
    public void create(TimeSignupModel timeSignupModel) {
        timeSignupDAO.create(timeSignupModel);
    }

    @Override
    public TimeSignupModel getTimeSignup(int Id) {
        return timeSignupDAO.get(Id);
    }

    @Override
    public void delete(int Id) {
        timeSignupDAO.delete(Id);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        TimeSignup timeSignup = new TimeSignup();
        int id = Integer.parseInt(request.getParameter("id")); //Không thay đổi giá trị Id trên form
        TimeSignupModel timeSignupModel = timeSignupDAO.get(id); // Lấy được cái model thông qua id
        String startdate = request.getParameter("startday");
        String enddate = request.getParameter("startday");
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
            timeSignupModel.setStartday(start);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
            timeSignupModel.setEndday(end);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        timeSignupModel.setRole(request.getParameter("role"));


        timeSignup.setId(timeSignupModel.getId()); //Lấy lại Id củ
        timeSignup.setEndday(timeSignupModel.getEndday());
        timeSignup.setRole(timeSignupModel.getRole());

        timeSignupDAO.update(timeSignup);
        response.sendRedirect("");
    }

    public List<TimeSignupModel> getAll() {
        return timeSignupDAO.getAll();
    }

    public TimeSignupModel getByRole(String role){
        return timeSignupDAO.getByRole(role);
    }
}