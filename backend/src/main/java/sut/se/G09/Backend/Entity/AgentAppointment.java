package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;

@Entity @Data @Getter @Setter @ToString @EqualsAndHashCode
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
    public AgentAppointment() { }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = InsuranceTypes.class)
    @JoinColumn(name = "insuranceId", insertable = true)
    private InsuranceTypes insuranceType;

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