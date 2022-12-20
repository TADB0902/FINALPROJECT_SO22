package service;

import model.LoginModel;
import model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IServiceUser {
    LoginModel login(String username, String password, String role);
    UserModel getUser (String username);
    void create(UserModel userModel);

    void update(HttpServletRequest request, HttpServletResponse response);

    void updateUser(UserModel userModel);

    List<UserModel> getAllUser();

    List<UserModel> getTeacher(String idTeacher, String faculty);
}
