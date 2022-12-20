package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullname;

    @Column
    private String gender;

    @Column
    private String email;

    @Column
    private Date birthday;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String schoolyear;
    @Column
    private String faculty;

    @Column
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TopicOfTeacher> topicOfTeachers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TopicOfStudent> topicOfStudents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CouncilMembers> councilMembers;

    @OneToMany(mappedBy = "leader", cascade = CascadeType.ALL)
    private List<Councils> councils;
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<TopicOfTeacher> getTopicOfTeachers() {
        return topicOfTeachers;
    }

    public void setTopicOfTeachers(List<TopicOfTeacher> topicOfTeachers) {
        this.topicOfTeachers = topicOfTeachers;
    }
}