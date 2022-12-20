package controller.headofdepartmet;

import entity.Councils;
import entity.User;
import model.CouncilModel;
import model.CouncilMembersModel;
import model.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.CouncilService;
import service.CouncilMemberService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/headofdepartment/council/create/acouncil")
public class CreateACouncilController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(idCouncil);
        String username = request.getParameter("username");
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        CouncilMembersModel councilMembersModel = new CouncilMembersModel();

        Councils councils = new Councils();
        try {
            BeanUtils.copyProperties(councils, councilModel);
            councilMembersModel.setCouncils(councils);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
            councilMembersModel.setUser(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        CouncilMemberService councilMemberService = new CouncilMemberService();
        String check = "false";
        if(councilModel.getLeader() != null)
        {
            check = councilModel.getLeader().getUsername();
        }
        if(councilMemberService.check(idCouncil,username) > 0 || username.equals(check)){
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=danger");
        }
        else {
            councilMemberService.create(councilMembersModel);
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=success");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCouncil = Integer.parseInt(request.getParameter("idCouncil"));
        System.out.println(idCouncil);
        CouncilService councilService = new CouncilService();
        CouncilModel councilModel = councilService.get(idCouncil);
        String username = request.getParameter("username");
        UserService userService = new UserService();
        UserModel userModel = userService.getUser(username);
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
            councilModel.setLeader(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        CouncilMemberService councilMemberService = new CouncilMemberService();
        if(councilMemberService.check(idCouncil,username) > 0 ){
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=danger");
        }
        else {
            councilService.update(councilModel);
            response.sendRedirect("../create?idCouncil="+idCouncil+"&message=success");
        }
    }

}
