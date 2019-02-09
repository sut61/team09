package sut.se.G09.Backend.Entity;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @NotNull(message="ID card number is null")
    @Pattern(regexp = "[\\d]{13}", message = "{ID card number pattern is invalid}")
    private String idCardNum;

    @NotNull(message="First name is null")
    @Size(max=30, message = "{First name length must less than 30 character}")
    private String fName;

    @NotNull(message="Last name is null")
    @Size(max=30, message = "{Last name length must less than 30 character}")
    private String lName;

    public CancelAppointmentHistory() {}

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