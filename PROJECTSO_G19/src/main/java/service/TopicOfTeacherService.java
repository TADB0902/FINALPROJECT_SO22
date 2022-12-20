package service;

import dao.TopicOfTeacherDAO;
import model.TopicOfTeacherModel;

import java.util.List;

public class TopicOfTeacherService implements IServiceTopicOfTeacher {

    TopicOfTeacherDAO topicOfTeacherDAO = new TopicOfTeacherDAO();

    @Override
    public void create(TopicOfTeacherModel topicOfTeacherModel)
    {
        topicOfTeacherDAO.create(topicOfTeacherModel);
    }
    @Override
    public List<TopicOfTeacherModel> GetList(String username){
         return topicOfTeacherDAO.GetList(username);
    }
    public List<TopicOfTeacherModel> GetAll(){
        return topicOfTeacherDAO.getAll();
    }
    @Override
    public List<TopicOfTeacherModel> GetListFaculty(String department){
        return topicOfTeacherDAO.GetListDepartment(department);
    }
    public TopicOfTeacherModel getUser(int id)
    {
        return topicOfTeacherDAO.get(id);
    }
    public void update(TopicOfTeacherModel topicOfTeacherModel){
        topicOfTeacherDAO.update(topicOfTeacherModel);
    }
}
