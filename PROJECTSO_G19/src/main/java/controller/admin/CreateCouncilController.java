package controller.admin;

import entity.TopicOfStudent;
import model.CouncilModel;
import model.TopicOfStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import service.CouncilService;
import service.TopicOfStudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/council/create")
public class CreateCouncilController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CouncilModel councilModel = new CouncilModel();
        int topicid = Integer.parseInt(request.getParameter("topicid"));
        int numberTeacher = Integer.parseInt(request.getParameter("NumberTeacher"));
        String date = request.getParameter("date");
        TopicOfStudentService topicOfStudentService = new TopicOfStudentService();
        TopicOfStudentModel topicOfStudentModel = topicOfStudentService.getStudent(topicid);
        TopicOfStudent topicOfStudent = new TopicOfStudent();
        try {
            BeanUtils.copyProperties(topicOfStudent, topicOfStudentModel);
            councilModel.setTopicOfStudent(topicOfStudent);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        try {
            Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(date);
            councilModel.setCountdate(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        councilModel.setStatus("Unassigned");
        councilModel.setNumberTeachers(numberTeacher);
        CouncilService councilService = new CouncilService();
        councilService.create(councilModel);
        response.sendRedirect("../council?message=create");
    }
}
