package controller.teachers;

import entity.User;
import model.TopicOfTeacherModel;
import model.TimeSignupModel;
import model.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.TopicOfTeacherService;
import service.TimeSignUpService;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/giangvien/dangki/create")
public class SignUpTopicOfTeacherController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        TopicOfTeacherModel topicOfTeacherModel = new TopicOfTeacherModel();
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        String time = current.format(formatter);
        Date date2;
        try {
            date2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").parse(time);
            System.out.println(date2);
            topicOfTeacherModel.setcreateDate(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        topicOfTeacherModel.setTopic(request.getParameter("topic"));
        topicOfTeacherModel.setfaculty(request.getParameter("faculty"));
        topicOfTeacherModel.setUser(user);
        topicOfTeacherModel.setRequest(request.getParameter("request"));
        topicOfTeacherModel.setTarget(request.getParameter("target"));
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();

        TimeSignUpService timeSignUpService = new TimeSignUpService();
        TimeSignupModel timeSignupModel = timeSignUpService.getByRole(userModel.getRole());

        if(timeSignupModel == null){
            response.sendRedirect(request.getContextPath()+"/giangvien/dangki?message=register_error");
        }
        else if ((date2.after(timeSignupModel.getStartday()) && date2.before(timeSignupModel.getEndday()))
                && timeSignupModel != null)
        {
            topicOfTeacherService.create(topicOfTeacherModel);
            response.sendRedirect(request.getContextPath()+"/giangvien/dangki");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/giangvien/dangki?message=register_error");
        }

    }
}
