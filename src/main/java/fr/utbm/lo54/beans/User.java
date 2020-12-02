package fr.utbm.lo54.beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="client")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "COURSE_SESSION_ID")
    private CourseSession course_session;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getCourse_session() {
        return course_session;
    }

    public void setCourse_session(CourseSession course_session) {
        this.course_session = course_session;
    }

}
