package service;

import model.TopicOfTeacherModel;

import java.util.List;

public interface IServiceTopicOfTeacher {
    void create(TopicOfTeacherModel topicOfTeacherModel);
    List<TopicOfTeacherModel> GetList(String username);
    List<TopicOfTeacherModel> GetListFaculty(String faculty);
}
