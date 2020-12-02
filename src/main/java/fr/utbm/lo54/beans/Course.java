package fr.utbm.lo54.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE")
    private String code;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseSession> sessions;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CourseSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CourseSession> sessions) {
        this.sessions = sessions;
    }
}
