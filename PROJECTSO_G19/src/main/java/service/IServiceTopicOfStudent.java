package service;

import model.TopicOfStudentModel;

import java.util.List;

public interface IServiceTopicOfStudent {
    List<TopicOfStudentModel> GetList(String department);
}
