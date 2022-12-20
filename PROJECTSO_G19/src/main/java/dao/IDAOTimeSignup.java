package dao;

import entity.TimeSignup;
import model.TimeSignupModel;

public interface IDAOTimeSignup {
    void create(TimeSignupModel timeSignupModel);
    TimeSignupModel get(int Id);
    void update(TimeSignup timeSignup);
    void delete(int Id);
}