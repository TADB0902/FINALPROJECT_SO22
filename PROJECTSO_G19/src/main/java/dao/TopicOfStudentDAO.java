package dao;

import model.TopicOfStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.TopicOfStudentService;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class TopicOfStudentDAO implements IDAOTopicOfStudent {
    @Override
    public List<TopicOfStudentModel> GetList(String department){
        return null;
    }

    public List<TopicOfStudentModel> GetListByStatusArgument(String StatusArgument, String status){

        Transaction transaction = null;
        List<TopicOfStudentModel> topicOfStudentModels = new ArrayList<>();
        List<entity.TopicOfStudent> topicOfStudents = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select p From TopicOfStudent as p Where p.statusArgument = :StatusArgument and p.status= :status";
            topicOfStudents = session.createQuery(qr).setParameter("StatusArgument", StatusArgument).setParameter("status", status).getResultList();
            for(entity.TopicOfStudent topicOfStudent : topicOfStudents)
            {
                TopicOfStudentModel p = new TopicOfStudentModel();
                BeanUtils.copyProperties(p, topicOfStudent);
                topicOfStudentModels.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicOfStudentModels;

    }
    public void create(TopicOfStudentModel topicOfStudentModel){
        entity.TopicOfStudent topicOfStudent = new entity.TopicOfStudent();
        Transaction transaction = null;

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(topicOfStudent, topicOfStudentModel);
            transaction = session.beginTransaction();

            session.save(topicOfStudent);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public TopicOfStudentModel Get(String user){
        TopicOfStudentModel topicOfStudentModel = new TopicOfStudentModel();
        List<entity.TopicOfStudent> topicOfStudents = null;
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select p From TopicOfStudent as p Where p.user.username = :user";
            topicOfStudents = session.createQuery(qr, entity.TopicOfStudent.class).setParameter("user", user).getResultList();
            if(topicOfStudents != null){
                for(entity.TopicOfStudent topicOfStudent : topicOfStudents){
                BeanUtils.copyProperties(topicOfStudentModel, topicOfStudent);
                return topicOfStudentModel;}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public TopicOfStudentModel getById(int id) {
        TopicOfStudentModel topicOfStudentModel = new TopicOfStudentModel();
        entity.TopicOfStudent topicOfStudent = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            topicOfStudent = session.get(entity.TopicOfStudent.class, id);
            BeanUtils.copyProperties(topicOfStudentModel, topicOfStudent);
            return topicOfStudentModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            entity.TopicOfStudent topicOfStudent = session.get(entity.TopicOfStudent.class, id);
            if (topicOfStudent != null) {
                session.delete(topicOfStudent);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void update(TopicOfStudentModel topicOfStudentModel){
        Transaction transaction = null;
        entity.TopicOfStudent topicOfStudent = new entity.TopicOfStudent();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(topicOfStudent, topicOfStudentModel);
            session.update(topicOfStudent);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
