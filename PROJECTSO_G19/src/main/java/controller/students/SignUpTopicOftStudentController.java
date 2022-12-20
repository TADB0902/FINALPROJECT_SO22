package controller.students;

import entity.TopicOfTeacher;
import entity.User;
import model.TopicOfTeacherModel;
import model.TopicOfStudentModel;
import model.TimeSignupModel;
import model.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import service.TopicOfTeacherService;
import service.TopicOfStudentService;
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

@WebServlet("/sinhvien/dangki/create")
public class SignUpTopicOftStudentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        TopicOfStudentModel topicOfStudentModel = new TopicOfStudentModel();
        UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
        User user = new User();
        try {
            BeanUtils.copyProperties(user, userModel);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        TopicOfTeacherService topicOfTeacherService = new TopicOfTeacherService();
        TopicOfTeacherModel topicOfTeacherModel = topicOfTeacherService.getUser(Integer.parseInt(request.getParameter("id")));
        TopicOfTeacher topicOfTeacher = new TopicOfTeacher();
        try {
            BeanUtils.copyProperties(topicOfTeacher, topicOfTeacherModel);
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
            topicOfStudentModel.setcreateDate(date2);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        topicOfStudentModel.setStatus("Not Approve");
        topicOfStudentModel.setStatusArgument("No");
        topicOfStudentModel.setUser(user);
        topicOfStudentModel.setTopicOfTeacher(topicOfTeacher);

        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();

        TimeSignUpService timeSignUpService = new TimeSignUpService();

        TimeSignupModel timeSignupModel = timeSignUpService.getByRole(userModel.getRole());
        if(timeSignupModel == null) {

        }
        if(timeSignupModel == null)
        {
            response.sendRedirect(request.getContextPath()+"/sinhvien/dangki/change?message=error");
        }
        else if ((date2.after(timeSignupModel.getStartday()) && date2.before(timeSignupModel.getEndday())) && timeSignupModel != null)
        {
            topicOfStudentService.create(topicOfStudentModel);
            response.sendRedirect(request.getContextPath()+"/sinhvien/dangki/change");
        }
        else {
            response.sendRedirect(request.getContextPath()+"/sinhvien/dangki/change?message=error");
        }
    }
}
