package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;

@Entity @Data @Getter @Setter
@Table(name = "AgentAppointment", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class AgentAppointment {
    @Id @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)

    private Long appointmentId;
    private String fName;
    private String lName;
    private int age;
    private String telNum;
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