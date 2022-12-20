package entity;

import javax.persistence.*;

@Entity
@Table(name = "councilmembers")
public class CouncilMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    private Councils councils;

    @ManyToOne
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