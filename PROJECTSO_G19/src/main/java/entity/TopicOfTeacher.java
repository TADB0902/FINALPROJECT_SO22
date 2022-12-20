package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topicofteacher")
public class TopicOfTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private User user;

    @Column
    private String topic;

    @Column
    private String target;

    @Column
    private String request;

    @Column
    private String faculty;

    @Column
    private Date createDate;

    @OneToMany(mappedBy = "topicOfTeacher", cascade = CascadeType.ALL)
    private List<TopicOfStudent> topicOfStudents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<TopicOfStudent> getTopicOfStudents() {
        return topicOfStudents;
    }

    public void setTopicOfStudents(List<TopicOfStudent> topicOfStudents) {
        this.topicOfStudents = topicOfStudents;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


}