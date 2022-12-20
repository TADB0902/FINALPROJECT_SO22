package model;

import entity.TopicOfTeacher;
import entity.User;

import java.util.Date;

public class TopicOfStudentModel {
    private int id;

    private User user;

    private TopicOfTeacher topicOfTeacher;

    private String status;

    private int point;

    private  String reviews;

    private String statusArgument;

    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TopicOfTeacher getTopicOfTeacher() {
        return topicOfTeacher;
    }

    public void setTopicOfTeacher(TopicOfTeacher topicOfTeacher) {
        this.topicOfTeacher = topicOfTeacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getStatusArgument() {
        return statusArgument;
    }

    public void setStatusArgument(String statusArgument) {
        this.statusArgument = statusArgument;
    }
}

