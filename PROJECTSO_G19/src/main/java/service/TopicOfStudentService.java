package service;

import dao.TopicOfStudentDAO;
import model.TopicOfStudentModel;

import java.util.List;

public class TopicOfStudentService implements IServiceTopicOfStudent {
    @Override
    public List<TopicOfStudentModel> GetList(String department){
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        return topicOfStudentDAO.GetList(department);
    }


    public void create(TopicOfStudentModel topicOfStudentModel)
    {
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        topicOfStudentDAO.create(topicOfStudentModel);
    }
    public TopicOfStudentModel Get(String user){
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        return topicOfStudentDAO.Get(user);
    }

    public List<TopicOfStudentModel> GetListByStatusArgument(String StatusArgument, String status){
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        return topicOfStudentDAO.GetListByStatusArgument(StatusArgument, status);
    }
    public TopicOfStudentModel getStudent(int id) {
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        return topicOfStudentDAO.getById(id);
    }
    public void update(TopicOfStudentModel topicOfStudentModel) {
        TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
        topicOfStudentDAO.update(topicOfStudentModel);
    }
}
