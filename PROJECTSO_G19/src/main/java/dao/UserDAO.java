package dao;

import entity.User;
import model.LoginModel;
import model.UserModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements IDAOUser{


    @Override
    public LoginModel login(String username, String password, String role) {
        LoginModel loginModel = new LoginModel();
        User user = new User();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query q1 = session.createQuery("from User where username like :s1 and password like :s2 and role like :s3");
            q1.setParameter("s1",  username );
            q1.setParameter("s2", password);
            q1.setParameter("s3", role);
            user = (User) q1.getSingleResult();
            BeanUtils.copyProperties(loginModel, user);
            return loginModel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(UserModel userModel) {
        User user = new User();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(user, userModel);
            transaction = session.beginTransaction();

            session.save(user);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public UserModel get(String username) {
        UserModel userModel = new UserModel();
        User user = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            user = session.get(User.class, username);
            BeanUtils.copyProperties(userModel, user);
            return  userModel;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<UserModel> getAll() {
        List<UserModel> userModels = new ArrayList<>();
        List<User> users = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
            criteriaQuery.from(User.class);
            users = session.createQuery(criteriaQuery).getResultList();
            for(User s: users){
                UserModel userModel = new UserModel();
                BeanUtils.copyProperties(userModel, s);
                userModels.add(userModel);
            }

            return userModels;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    @Override
    public void update(UserModel userModel) {
        Transaction transaction = null;
        User user = new User();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(user, userModel);
            session.update(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public List<UserModel> GetList(String username, String department) {
        Transaction transaction = null;
        List<UserModel> userModels = new ArrayList<>();
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select u From User as u Where u.username != :username and u.department= :department and u.role = :role";
            users = session.createQuery(qr).setParameter("username", username).setParameter("department", department).setParameter("role", "giangvien").getResultList();
            for(User user: users)
            {
                UserModel u = new UserModel();
                BeanUtils.copyProperties(u, user);
                userModels.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userModels;
    }

    public List<UserModel> getListSearch(String username, String search, String department) {
        Transaction transaction = null;
        List<UserModel> userModels = new ArrayList<>();
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select u From User as u Where u.username != :username and u.role = :role and u.faculty= :faculty and u.fullname like :search";
            users = session.createQuery(qr).setParameter("username", username).setParameter("role", "giangvien").setParameter("faculty", department).setParameter("search","%"+search +"%").getResultList();
            for(User user: users)
            {
                UserModel u = new UserModel();
                BeanUtils.copyProperties(u, user);
                userModels.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userModels;
    }
    
}
