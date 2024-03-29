package gr.hua.dit.ds.alfinal.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer Id;

    @Column
    private String title;

    public Appointment(String title) {
        this.title = title;
    }

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="request_appointment",
            joinColumns = @JoinColumn(name="appointment_id"),
            inverseJoinColumns = @JoinColumn(name="request_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames={"appointment_id", "request_id"})}
    )
    private List<Request> requests;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Appointment() {
    }

    public Integer getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setTittle(String tittle) {
        this.title = title;
    }
}
