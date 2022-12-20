package dao;

import entity.TopicOfStudent;
import model.TopicOfStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class ApproveTopicDAO implements IDAOApproveTopic {
    @Override
    public void update(TopicOfStudent topicOfStudent) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(topicOfStudent);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public TopicOfStudentModel get(int Id) {
        TopicOfStudentModel topicOfStudentModel = new TopicOfStudentModel();
        TopicOfStudent topicOfStudent = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            topicOfStudent = session.get(TopicOfStudent.class, Id);
            BeanUtils.copyProperties(topicOfStudentModel, topicOfStudent);
            return topicOfStudentModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<TopicOfStudentModel> getAll(String faculty) {
        Transaction transaction = null;
        List<TopicOfStudentModel> topicOfStudentModels = new ArrayList<>();
        List<TopicOfStudent> topicOfStudents = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select t From TopicOfStudent as t Where t.topicOfTeacher.faculty = :faculty ";
            topicOfStudents = session.createQuery(qr).setParameter("faculty", faculty).getResultList();
            for(TopicOfStudent topicOfStudent : topicOfStudents)
            {
                TopicOfStudentModel p = new TopicOfStudentModel();
                BeanUtils.copyProperties(p, topicOfStudent);
                topicOfStudentModels.add(p);
            }
            return topicOfStudentModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}