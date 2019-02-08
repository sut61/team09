package sut.se.G09.Backend.Entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity @Data
@Table(name = "CancelAppointmentHistory", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class CancelAppointmentHistory {
    @Id
    @SequenceGenerator(name = "cancelAppointment_seq", sequenceName = "cancelAppointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelAppointment_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long cancelId;

    @NotNull
    private String idCardNum;

    @NotNull
    private String fName;

    @NotNull
    private String lName;


    public String getIdCardNum() { return idCardNum; }

    public void setIdCardNum(String idCardNum) { this.idCardNum = idCardNum; }

    public String getfName() { return fName; }

    public void setfName(String fName) { this.fName = fName; }

    public String getlName() { return lName; }

    public void setlName(String lName) { this.lName = lName; }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CancelAppointmentReason.class)
    @JoinColumn(name = "reasonId", insertable = true)
    private CancelAppointmentReason cancelAppointmentReason;

}