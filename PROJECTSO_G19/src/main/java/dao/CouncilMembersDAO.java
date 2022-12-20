package dao;

import entity.CouncilMembers;
import model.CouncilMembersModel;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class CouncilMembersDAO {
    public void create(CouncilMembersModel councilMembersModel) {
        CouncilMembers councilMembers = new CouncilMembers();
        Transaction transaction = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            BeanUtils.copyProperties(councilMembers, councilMembersModel);
            transaction = session.beginTransaction();

            session.save(councilMembers);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<CouncilMembersModel> getList(int idCouncil) {
        Transaction transaction = null;
        List<CouncilMembersModel> councilMembersModels = new ArrayList<>();
        List<CouncilMembers> councilMembers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select m From CouncilMembers as m Where m.councils.id = :idCouncil ";
            councilMembers = session.createQuery(qr).setParameter("idCouncil", idCouncil).getResultList();
            for(CouncilMembers councilmembers : councilMembers)
            {
                CouncilMembersModel m = new CouncilMembersModel();
                BeanUtils.copyProperties(m, councilMembers);
                councilMembersModels.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return councilMembersModels;
    }
    public List<CouncilMembersModel> getListSearch(int idCouncil, String search) {
        Transaction transaction = null;
        List<CouncilMembersModel> councilMembersModels = new ArrayList<>();
        List<CouncilMembers> councilMembers = new ArrayList<>();
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select m From CouncilMembers as m Where m.councils.id = :idCouncil and m.user.fullname like :search";
            councilMembers = session.createQuery(qr).setParameter("idCouncil", idCouncil).setParameter("search","'%"+search +"%'").getResultList();
            for(CouncilMembers councilmembers : councilMembers)
            {
                CouncilMembersModel m = new CouncilMembersModel();
                BeanUtils.copyProperties(m, councilMembers);
                councilMembersModels.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return councilMembersModels;
    }

    public int count(int id) {
        Transaction transaction = null;
        int count =0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select m From CouncilMembers as m where m.councils.id= :id";
            count = (int) session.createQuery(qr).setParameter("id",id).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public int check(int id, String username) {
        Transaction transaction = null;
        int count =0;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String qr = "Select m From CouncilMembers as m where m.councils.id= :id and m.user.username= :username";
            count = (int) session.createQuery(qr).setParameter("id",id).setParameter("username", username).stream().count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            CouncilMembers councilMembers = session.get(CouncilMembers.class, id);
            if (councilMembers != null) {
                session.delete(councilMembers);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void deleteAll(int idCouncil) {
        Transaction transaction = null;
        List<CouncilMembers> councilMembers = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String qr = "Select m From CouncilMembers as m Where m.councils.id = :idCouncil ";
            councilMembers = session.createQuery(qr).setParameter("idCouncil", idCouncil).getResultList();
            for(CouncilMembers councilmembers : councilMembers)
            {
                CouncilMembers councilMembers1 = session.get(CouncilMembers.class, councilmembers.getId());
                if (councilMembers1 != null) {
                    session.delete(councilMembers1);
                }
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
