package service;

import model.TopicOfStudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface IServiceApproveTopic {
    void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    List<TopicOfStudentModel> getTopicOfStudent(String faculty);
}