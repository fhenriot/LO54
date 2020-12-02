package fr.utbm.lo54.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="course_session")
public class CourseSession implements Serializable {
    public static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "START_DATE")
    private Date start_date;

    @Column(name = "END_DATE")
    private Date end_date;

    @Column(name = "MAXIMUM")
    private int maximum;

    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;
}