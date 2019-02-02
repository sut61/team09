package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity @Data @Getter @Setter
@Table(name = "AgentAppointment", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class AgentAppointment {
    @Id @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long appointmentId;

    @NotNull(message="Please enter First name")
    @Size(min=2,max=30, message = "{agentAppointment.fName.invalid}")
    private String fName;

    @NotNull(message="Please enter Last name")
    @Size(min=2,max=30, message = "{agentAppointment.lName.invalid}")
    private String lName;

    @NotNull
    @Range(min=1, max=80)
    private int age;

    @NotNull
    @Pattern(regexp = "[0]{1}[6,8,9]{1}[0-9]{8}")
    private String telNum;

    @Pattern(regexp = "[A-Za-z0-9][A-Za-z0-9.]{7}[A-Za-z0-9.]*@[a-z]+.[a-z.]+")
    private String email;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AgentAppointment() { }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "categoryId", insertable = true)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "genderId", insertable = true)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "provinceId", insertable = true)
    private Province province;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DateAppointment.class)
    @JoinColumn(name = "dateId", insertable = true)
    private DateAppointment dateAppointment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DurationAppointment.class)
    @JoinColumn(name = "durationId", insertable = true)
    private DurationAppointment durationAppointment;
}