package model;

import entity.Councils;
import entity.User;


public class CouncilMembersModel {
    private int id;

    private Councils councils;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Councils getCouncils() {
        return councils;
    }

    public void setCouncils(Councils councils) {
        this.councils = councils;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
