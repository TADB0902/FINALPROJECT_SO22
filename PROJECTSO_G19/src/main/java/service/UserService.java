package service;

import dao.IDAOUser;
import dao.UserDAO;
import model.LoginModel;
import model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService implements IServiceUser {
    IDAOUser userDAO = new UserDAO();
    @Override
    public LoginModel login(String username, String password, String role) {
        return userDAO.login(username, password, role);
    }

    @Override
    public UserModel getUser(String username){
        return userDAO.get(username);
    }

    @Override
    public void create(UserModel userModel) {
        userDAO.create(userModel);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        UserModel userModel = userDAO.get(username);
        userModel.setPassword(request.getParameter("password"));
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setGender(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        String birthday = request.getParameter("birthday");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            userModel.setBirthday(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);

        }
        userDAO.update(userModel);
    }
    @Override
    public void updateUser(UserModel userModel){
        userDAO.update(userModel);
    }

    @Override
    public List<UserModel> getAllUser(){return userDAO.getAll();}

    public List<UserModel> getTeacher(String username, String department)
    {
        return userDAO.GetList(username, department);
    }
    public List<UserModel> getListSearch(String username, String search, String department)
    {
        return userDAO.getListSearch(username, search, department);
    }
}
