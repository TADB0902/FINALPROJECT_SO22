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

@WebServlet(urlPatterns = "/admin/create")
public class CreateUsertController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/admin/taotaikhoan.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = new UserModel();
        try {
            userModel.setUsername(request.getParameter("username"));
            userModel.setPassword(request.getParameter("password"));
            userModel.setFullname(request.getParameter("fullname"));
            userModel.setGender(request.getParameter("gender"));
            userModel.setEmail(request.getParameter("email"));
            userModel.setAddress(request.getParameter("address"));
            userModel.setPhone(request.getParameter("phone"));
            userModel.setSchoolyear(request.getParameter("schoolyear"));
            userModel.setFaculty(request.getParameter("faculty"));
            userModel.setRole(request.getParameter("role"));
            String birthday = request.getParameter("birthday");
            try {
                Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                userModel.setBirthday(date1);
            } catch (ParseException e) {

                throw new RuntimeException(e);
            }
            userService.create(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("./account");
    }
}
