package dao;

import model.TopicOfStudentModel;

import java.util.List;

public interface IDAOTopicOfStudent {
    List<TopicOfStudentModel> GetList(String department);
}
