package fr.utbm.lo54.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course")
public class Course implements Serializable {
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseSession> sessions;
}
