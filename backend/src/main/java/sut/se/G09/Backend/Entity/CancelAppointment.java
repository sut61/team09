package sut.se.G09.Backend.Entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Data
@Table(name = "CancelAppointment", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class CancelAppointment {
    @Id
    @SequenceGenerator(name = "cancelAppointment_seq", sequenceName = "cancelAppointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelAppointment_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long cancelId;

    @NotNull
    private String fName;

    @NotNull
    private String lname;

    @NotNull
    private String email;

    public String getfName() { return fName; }

    public void setfName(String fName) { this.fName = fName; }

    public String getLname() { return lname; }

    public void setLname(String lname) { this.lname = lname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CancelAppointmentReason.class)
    @JoinColumn(name = "reasonId", insertable = true)
    private CancelAppointmentReason cancelAppointmentReason;

}