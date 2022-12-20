package controller.admin;

import model.UserModel;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/admin/account/edit")
public class EditUserController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserService userService = new UserService();
        List<UserModel> userModelList= userService.getAllUser();

        String username = request.getParameter("id");
        UserModel userModel = userService.getUser(username);
        String date1;
        date1 = new SimpleDateFormat("yyyy-MM-dd").format(userModel.getBirthday());
        request.setAttribute("date1",date1);
        request.setAttribute("user", userModel);
        request.setAttribute("userModelList", userModelList);
        request.setAttribute("action", "update");
        request.getRequestDispatcher("/views/admin/taotaikhoan.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username.trim());
        userModel.setPassword(request.getParameter("password"));
        userModel.setFullname(request.getParameter("fullname"));
        userModel.setGender(request.getParameter("male"));
        userModel.setEmail(request.getParameter("email"));
        userModel.setAddress(request.getParameter("address"));
        userModel.setPhone(request.getParameter("phone"));
        userModel.setSchoolyear(request.getParameter("schoolyear"));
        userModel.setFaculty(request.getParameter("department"));
        userModel.setRole(request.getParameter("role"));
        String birthday = request.getParameter("birthday");
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            userModel.setBirthday(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        userService.updateUser(userModel);
        response.sendRedirect("../account");
    }
}
