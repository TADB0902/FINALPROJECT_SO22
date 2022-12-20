package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topicofstudent")
public class TopicOfStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private TopicOfTeacher topicOfTeacher;

    @Column
    private String status;


    @Column
    private int point;

    @Column
    private String statusArgument;

    @Column
    private Date createDate;

    @OneToMany(mappedBy = "topicOfStudent", cascade = CascadeType.ALL)
    private List<Councils> councils;

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

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getStatusArgument() {
        return statusArgument;
    }

    public void setStatusArgument(String statusArgument) {
        this.statusArgument = statusArgument;
    }

    public List<Councils> getCouncils() {
        return councils;
    }

    public void setCouncils(List<Councils> councils) {
        this.councils = councils;
    }
}