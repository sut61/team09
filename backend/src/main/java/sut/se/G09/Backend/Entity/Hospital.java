package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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


    @NotNull(message="{Owner name is null}")
    @Size(min=2, message = "{Owner name length must more than 1 character}")
    @Size(max=30, message = "{Owner name length must less than 30 character}")
    private  String ownerfName;

    @NotNull(message="{Owner last name is null}")
    @Size(min=2, message = "{Owner last name length must more than 1 character}")
    @Size(max=30, message = "{Owner last name length must less than 30 character}")
    private  String ownerlName;

    @Pattern(regexp = "[0]{1}[2-9]{1}[0-9]{7}" , message = "{Phone number pattern is invalid}")
    private String phoneNum;

    @Pattern(regexp = "[A-Za-z0-9][A-Za-z0-9.]{7}[A-Za-z0-9.]*@[a-z]+.[a-z.]+", message = "{Email pattern is invalid}")
    private String email;


    public Hospital() {}
    public void setHospital( String hosName,String ownerfName,String ownerlName,String phoneNum,String email) {


        this.hosName = hosName;
        this.ownerfName = ownerfName;
        this.ownerlName = ownerlName;
        this.phoneNum = phoneNum;
        this.email = email;

    }
    public void setiD(Long iD) {
        this.iD = iD;
    }
    public void setHosName(String hosName) {
        this.hosName = hosName;
    }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }
    public void setEmail(String email) { this.email = email; }
    public void setOwnerfName(String ownerfName) { this.ownerfName = ownerfName; }
    public void setOwnerlName(String ownerlName) { this.ownerlName = ownerlName; }

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


}