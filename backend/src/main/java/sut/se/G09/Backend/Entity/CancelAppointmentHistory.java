package sut.se.G09.Backend.Entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotNull(message="{ID card number is null}")
    @Pattern(regexp = "[\\d]{13}", message = "{ID card number pattern is invalid}")
    private String idCardNum;

    @NotNull(message="{First name is null}")
    @Length(min=2, max=30, message = "{First name length must between 2 to 30 characters}")
    private String fName;

    @NotNull(message="{Last name is null}")
    @Size(min=2, message = "{Last name length must more than 1 character}")
    @Size(max=30, message = "{Last name length must less than 30 character}")
    private String lName;

    @Pattern(regexp = "[0]{1}[2-9]{1}[0-9]{8}" , message = "{Telephone number pattern is invalid}")
    private String telNum;

    @Pattern(regexp = "[A-Za-z0-9][A-Za-z0-9.]{7}[A-Za-z0-9.]*@[a-z]+.[a-z.]+", message = "{Email pattern is invalid}")
    private String email;

    @NotNull(message="{Date is null}")
    private Date date;

    public CancelAppointmentHistory() {}

    public String getIdCardNum() { return idCardNum; }

    public void setIdCardNum(String idCardNum) { this.idCardNum = idCardNum; }

    public String getfName() { return fName; }

    public void setfName(String fName) { this.fName = fName; }

    public String getlName() { return lName; }

    public void setlName(String lName) { this.lName = lName; }

    public String getTelNum() { return telNum; }

    public void setTelNum(String telNum) { this.telNum = telNum; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @NotNull(message="Cancel appointment reason not be null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CancelAppointmentReason.class)
    @JoinColumn(name = "reasonId", insertable = true)
    private CancelAppointmentReason cancelAppointmentReason;

}