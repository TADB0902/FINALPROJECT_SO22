package service;

import model.TimeSignupModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IServiceTimeSignUp {
    void create(TimeSignupModel timeSignupModel);

    TimeSignupModel getTimeSignup(int Id);
    void delete(int Id);
    void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}