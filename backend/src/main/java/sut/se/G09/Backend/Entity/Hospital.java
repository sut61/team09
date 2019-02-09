package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
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
    private String hosName;

    public Hospital() {}
    public Hospital(Long iD, String hosName) {
        this.iD = iD;
        this.hosName = hosName;
    }




    @ManyToOne
    @JoinColumn(name= "agent_id")
    private AgentRegistration agentRegistration;

    @ManyToOne
    @JoinColumn(name= "Category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name= "province_id")
    private Province province;

    @ManyToOne
    @JoinColumn(name= "hosSize_id")
    private HospitalSize hospitalSize;


    public void setAgentname(AgentRegistration agentRegis) {this.agentRegistration = agentRegis;
    }
    public void setProvince(Province province) {this.province = province;
    }

    public void setCategory(Category category) {this.category = category;
    }
    public void setHosSize(HospitalSize hosSize) {this.hospitalSize = hosSize;
    }

}