package fr.utbm.lo54.beans;

import javax.persistence.*;

@Entity
@Table(name="location")
public class location {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CITY")
    private String city;

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

    public location(long id, String city) {
        this.id = id;
        this.city = city;
    }

    public location() {
    }
}
