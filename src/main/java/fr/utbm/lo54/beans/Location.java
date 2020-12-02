package fr.utbm.lo54.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="location")
public class Location implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CITY")
    private String city;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<CourseSession> sessions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location(long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Location() {
    }
}
