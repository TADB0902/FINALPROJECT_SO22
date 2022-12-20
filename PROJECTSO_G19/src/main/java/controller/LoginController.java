package controller;

import model.LoginModel;
import model.UserModel;
import service.UserService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/login", "/logout"})
public class LoginController extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (url.contains("logout")) {
            SessionUtil.getInstance().removeValue(req, "USERMODEL");
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        if (url.contains("login")) {
            LoginModel model = userService.login(req.getParameter("username"), req.getParameter("password"), req.getParameter("role"));
            if (model != null) {
                UserModel userModel = userService.getUser(model.getUsername());
                SessionUtil.getInstance().putValue(req, "USERMODEL", userModel);
                if (model.getRole().equals("sinhvien")) {
                    resp.sendRedirect(req.getContextPath() + "/sinhvien/home");
                } else if (model.getRole().equals("giangvien")) {
                    resp.sendRedirect(req.getContextPath() + "/giangvien/home");
                } else if (model.getRole().equals("headofdepartment")) {
                    resp.sendRedirect(req.getContextPath() + "/headofdepartment/home");
                } else if (model.getRole().equals("admin")) {
                    resp.sendRedirect(req.getContextPath() + "/admin/home");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }
    }
}
