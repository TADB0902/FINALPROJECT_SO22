package dao;

import entity.Councils;
import model.CouncilModel;
import model.TopicOfStudentModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


public class CouncilDAO {
    public void create(CouncilModel councilModel){
        Councils councils = new Councils();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            int id = councilModel.getTopicOfStudent().getId();
            TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
            TopicOfStudentModel topicOfStudentModel = topicOfStudentDAO.getById(id);
            topicOfStudentModel.setStatusArgument("Yes");
            topicOfStudentDAO.update(topicOfStudentModel);
            BeanUtils.copyProperties(councils, councilModel);
            transaction = session.beginTransaction();
            session.save(councils);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<CouncilModel> getAll(String department, Object faculty) {
        List<CouncilModel> councilModels = new ArrayList<>();
        List<Councils> councils = null;
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select c From Councils as c Where c.topicOfStudent.topicOfTeacher.faculty = :faculty ";
            councils = session.createQuery(qr).setParameter("faculty", faculty).getResultList();
            for(Councils council: councils) {
                CouncilModel c = new CouncilModel();
                BeanUtils.copyProperties(c, council);
                councilModels.add(c);
            }
            return councilModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CouncilModel> getAll() {
        List<CouncilModel> councilModels = new ArrayList<>();
        List<Councils> councils = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Councils> criteriaQuery = builder.createQuery(Councils.class);
            criteriaQuery.from(Councils.class);
            councils = session.createQuery(criteriaQuery).getResultList();
            for(Councils s: councils){
                CouncilModel councilModel = new CouncilModel();
                BeanUtils.copyProperties(councilModel, s);
                councilModels.add(councilModel);
            }

            return councilModels;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int id, int idProject) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            TopicOfStudentDAO topicOfStudentDAO = new TopicOfStudentDAO();
            TopicOfStudentModel topicOfStudentModel = topicOfStudentDAO.getById(idProject);
            topicOfStudentModel.setStatusArgument("No");
            topicOfStudentDAO.update(topicOfStudentModel);
            Councils councils = session.get(Councils.class, id);
            if (councils != null) {
                session.delete(councils);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public CouncilModel get(int id) {
        CouncilModel councilModel = new CouncilModel();
        Councils councils = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            councils = session.get(Councils.class, id);
            BeanUtils.copyProperties(councilModel, councils);
            return  councilModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(CouncilModel councilModel) {
        Transaction transaction = null;
        Councils councils = new Councils();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(councils, councilModel);
            session.update(councils);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
