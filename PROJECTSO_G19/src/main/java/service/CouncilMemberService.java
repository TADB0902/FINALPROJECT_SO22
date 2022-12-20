package service;

import dao.CouncilMembersDAO;
import model.CouncilMembersModel;

import java.util.List;

public class CouncilMemberService {

    public void create(CouncilMembersModel councilMembersModel) {
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        councilMembersDAO.create(councilMembersModel);
    }

    public List<CouncilMembersModel> getList(int idCouncil){
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        return councilMembersDAO.getList(idCouncil);
    }

    public List<CouncilMembersModel> getListSearch(int idCouncil, String search){
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        return councilMembersDAO.getListSearch(idCouncil, search);
    }
    public int count(int id)
    {
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        return councilMembersDAO.count(id);
    }
    public void delete(int id)
    {
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        councilMembersDAO.delete(id);
    }
    public int check(int idCouncil, String username){
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        return councilMembersDAO.check(idCouncil, username);
    }
    public void deleteAll(int idCouncil)
    {
        CouncilMembersDAO councilMembersDAO = new CouncilMembersDAO();
        councilMembersDAO.deleteAll(idCouncil);
    }

}
