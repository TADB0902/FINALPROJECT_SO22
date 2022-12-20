package service;

import dao.CouncilDAO;
import model.CouncilModel;

import java.util.ArrayList;
import java.util.List;

public class CouncilService implements IServiceCouncil {
    public List<CouncilModel> ListCouncil(String faculty){
        List<CouncilModel> councilModels = new ArrayList<>();
        CouncilDAO councilDAO = new CouncilDAO();
        councilModels = councilDAO.getAll(faculty, faculty);
        return councilModels;
    }
    public List<CouncilModel> ListCouncil(){
        List<CouncilModel> councilModels = new ArrayList<>();
        CouncilDAO councilDAO = new CouncilDAO();
        councilModels = councilDAO.getAll();
        return councilModels;
    }

    public void create(CouncilModel councilModel) {
        CouncilDAO councilDAO = new CouncilDAO();
        councilDAO.create(councilModel);
    }
    public void delete(int id, int idTopic){
        CouncilDAO councilDAO = new CouncilDAO();
        councilDAO.delete(id, idTopic);
    }

    public CouncilModel get(int id){
        CouncilDAO councilDAO = new CouncilDAO();
        return councilDAO.get(id);
    }

    public void update(CouncilModel councilModel){
        CouncilDAO councilDAO = new CouncilDAO();
        councilDAO.update(councilModel);
    }
}
