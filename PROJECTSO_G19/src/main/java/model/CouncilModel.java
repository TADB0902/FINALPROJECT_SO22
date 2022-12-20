package model;

import entity.TopicOfStudent;
import entity.User;

import java.util.Date;

public class CouncilModel {
    private int id;

    private TopicOfStudent topicOfStudent;

    private int numberTeachers;

    private Date countdate;

    private User leader;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TopicOfStudent getTopicOfStudent() {
        return topicOfStudent;
    }

    public void setTopicOfStudent(TopicOfStudent topicOfStudent) {
        this.topicOfStudent = topicOfStudent;
    }

    public int getnumberTeachers() {
        return numberTeachers;
    }

    public void setNumberTeachers(int numberTeachers) {
        this.numberTeachers = numberTeachers;
    }

    public Date getCountdate() {
        return countdate;
    }

    public void setCountdate(Date countdate) {
        this.countdate = countdate;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
