package dao;

import entity.TopicOfStudent;
import model.TopicOfStudentModel;

import java.util.List;

public interface IDAOApproveTopic {
    void update(TopicOfStudent topicOfStudent);
    TopicOfStudentModel get(int Id);
    List<TopicOfStudentModel> getAll(String faculty);
}