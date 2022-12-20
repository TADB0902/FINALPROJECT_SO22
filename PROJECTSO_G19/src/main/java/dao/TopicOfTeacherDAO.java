package dao;

import model.TopicOfTeacherModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class TopicOfTeacherDAO implements IDAOTopicOfTeacher {
    @Override
    public void create(TopicOfTeacherModel topicOfTeacherModel){
        entity.TopicOfTeacher topicOfTeacher = new entity.TopicOfTeacher();
        Transaction transaction = null;

        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(topicOfTeacher, topicOfTeacherModel);
            transaction = session.beginTransaction();

            session.save(topicOfTeacher);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            entity.TopicOfTeacher topicOfTeacher = session.get(entity.TopicOfTeacher.class, id);
            if (topicOfTeacher != null) {
                session.delete(topicOfTeacher);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public TopicOfTeacherModel get(int id) {
        TopicOfTeacherModel topicOfTeacherModel = new TopicOfTeacherModel();
        entity.TopicOfTeacher topicOfTeacher = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            topicOfTeacher = session.get(entity.TopicOfTeacher.class, id);
            BeanUtils.copyProperties(topicOfTeacherModel, topicOfTeacher);
            return topicOfTeacherModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(TopicOfTeacherModel topicOfTeacherModel) {
        Transaction transaction = null;
        entity.TopicOfTeacher topicOfTeacher = new entity.TopicOfTeacher();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(topicOfTeacher, topicOfTeacherModel);
            session.update(topicOfTeacher);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<TopicOfTeacherModel> GetList(String username) {
        Transaction transaction = null;
        List<TopicOfTeacherModel> topicOfTeacherModels = new ArrayList<>();
        List<entity.TopicOfTeacher> topicOfTeachers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select t From TopicOfTeacher as t Where t.user.username = :username";
            topicOfTeachers = session.createQuery(qr).setParameter("username", username).getResultList();
            for(entity.TopicOfTeacher topicOfTeacher1 : topicOfTeachers)
            {
                TopicOfTeacherModel p = new TopicOfTeacherModel();
                BeanUtils.copyProperties(p, topicOfTeacher1);
                topicOfTeacherModels.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicOfTeacherModels;
    }

    public List<TopicOfTeacherModel> GetListDepartment(String faculty) {
        Transaction transaction = null;
        List<TopicOfTeacherModel> topicOfTeacherModels = new ArrayList<>();
        List<entity.TopicOfTeacher> topicOfTeachers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select t From TopicOfTeacher as t Where t.faculty = :faculty";
            topicOfTeachers = session.createQuery(qr).setParameter("faculty", faculty).getResultList();
            for(entity.TopicOfTeacher topicOfTeacher1 : topicOfTeachers)
            {
                TopicOfTeacherModel p = new TopicOfTeacherModel();
                BeanUtils.copyProperties(p, topicOfTeacher1);
                topicOfTeacherModels.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topicOfTeacherModels;
    }
    public List<TopicOfTeacherModel> getAll() {
        List<TopicOfTeacherModel> topicOfTeacherModels = new ArrayList<>();
        List<entity.TopicOfTeacher> topicOfTeachers = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<entity.TopicOfTeacher> criteriaQuery = builder.createQuery(entity.TopicOfTeacher.class);
            criteriaQuery.from(entity.TopicOfTeacher.class);
            topicOfTeachers = session.createQuery(criteriaQuery).getResultList();
            for(entity.TopicOfTeacher s: topicOfTeachers){
                TopicOfTeacherModel topicOfTeacherModel = new TopicOfTeacherModel();
                BeanUtils.copyProperties(topicOfTeacherModel, s);
                topicOfTeacherModels.add(topicOfTeacherModel);
            }

            return topicOfTeacherModels;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
