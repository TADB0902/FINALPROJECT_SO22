package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "council")
public class Councils {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private TopicOfStudent topicOfStudent;

    @Column
    private int numberTeacher;

    @Column
    private Date dateCounterArgument;

    @ManyToOne
    private User leader;

    @Column
    private String status;

    @OneToMany(mappedBy = "councils", cascade = CascadeType.ALL)
    private List<CouncilMembers> councilMembers;

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

    public int getnumberTeacher() {
        return numberTeacher;
    }

    public void setnumberTeacher(int numberTeacher) {
        this.numberTeacher = numberTeacher;
    }

    public Date getDateCounterArgument() {
        return dateCounterArgument;
    }

    public void setDateCounterArgument(Date dateCounterArgument) {
        this.dateCounterArgument = dateCounterArgument;
    }

    public List<CouncilMembers> getCouncilMembers() {
        return councilMembers;
    }

    public void setCouncilMembers(List<CouncilMembers> councilMembers) {
        this.councilMembers = councilMembers;
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