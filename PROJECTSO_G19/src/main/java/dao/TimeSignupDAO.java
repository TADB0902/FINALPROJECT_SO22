package dao;

import entity.TimeSignup;
import model.TimeSignupModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class TimeSignupDAO implements IDAOTimeSignup {

    public List<TimeSignupModel> getAll() {
        List<TimeSignupModel> timeSignupModelList = new ArrayList<>();
        List<TimeSignup> timeSignupList = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<TimeSignup> criteriaQuery = builder.createQuery(TimeSignup.class);
            criteriaQuery.from(TimeSignup.class);
            timeSignupList = session.createQuery(criteriaQuery).getResultList();
            for(TimeSignup s: timeSignupList){
                TimeSignupModel timeSignupModel = new TimeSignupModel();
                BeanUtils.copyProperties(timeSignupModel, s);
                timeSignupModelList.add(timeSignupModel);
            }
            return timeSignupModelList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public void create(TimeSignupModel timeSignupModel){
        TimeSignup timeSignup = new TimeSignup();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(timeSignup, timeSignupModel);
            transaction = session.beginTransaction();

            session.save(timeSignup);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public TimeSignupModel get(int Id) {
        TimeSignupModel timeSignupModel = new TimeSignupModel();
        TimeSignup timeSignup = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            timeSignup = session.get(TimeSignup.class, Id);
            BeanUtils.copyProperties(timeSignupModel, timeSignup);
            return timeSignupModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(TimeSignup timeSignup) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(timeSignup);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(int Id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            TimeSignup timeSignup = session.get(TimeSignup.class, Id);
            if (timeSignup != null) {
                session.delete(timeSignup);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public TimeSignupModel getByRole(String role) {
        TimeSignupModel timeSignupModel = new TimeSignupModel();
        TimeSignup timeSignup = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            timeSignup = session.createQuery("From TimeSignup as  c WHERE c.role = :role", TimeSignup.class).setParameter("role", role).uniqueResult();
            BeanUtils.copyProperties(timeSignupModel, timeSignup);
            return timeSignupModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}