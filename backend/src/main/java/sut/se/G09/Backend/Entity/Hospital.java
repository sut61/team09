package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Hospital", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class Hospital {


    @Id
    @SequenceGenerator(name = "hospital_seq", sequenceName = "hospital_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long iD;

    @Column( unique = true)
    @NotNull(message="{Hospital name is null}")
    @Size(min=5, message = "{Hospital name length must more than 5 character}")
    @Size(max=30, message = "{Hospital name length must less than 30 character}")
    private String hosName;

    public Hospital() {}
    public Hospital(Long iD, String hosName) {
        this.iD = iD;

        this.hosName = hosName;
    }
    public void setiD(Long iD) {
        this.iD = iD;
    }




    @NotNull(message="AgentRegistration not be null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AgentRegistration.class)
    @JoinColumn(name= "agent_id")
    private AgentRegistration agentRegistration;

    @NotNull(message="Category not be null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name= "Category_id")
    private Category category;

    @NotNull(message="Province not be null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name= "province_id")
    private Province province;

    @NotNull(message="HospitalSize not be null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = HospitalSize.class)
    @JoinColumn(name= "hosSize_id")
    private HospitalSize hospitalSize;


    public void setAgentRegistration(AgentRegistration agentRegis) {this.agentRegistration = agentRegis;
    }
    public void setProvince(Province province) {this.province = province;
    }

    public void setCategory(Category category) {this.category = category;
    }
    public void setHospitalSize(HospitalSize hosSize) {this.hospitalSize = hosSize;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName;
    }
}