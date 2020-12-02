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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}