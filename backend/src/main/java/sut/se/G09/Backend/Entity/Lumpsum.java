package sut.se.G09.Backend.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import  java.util.*;
import java.util.Date;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Lumpsum") //ชื่อตาราง
public class Lumpsum {
    @Id
    @SequenceGenerator(name="lumpsum_seq",sequenceName="lumpsum_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="lumpsum_seq")
    @Column(name="LUMPSUM_ID",unique = true, nullable = true)
    private @NonNull Long iD;
    private String companyName;
    private int amoungEmp;
    private Long address;
    private String zipCode;
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BusinessSize.class)
    @JoinColumn(name = "BUSINESS_ID", insertable = true)
    private  BusinessSize businessSizeId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID", insertable = true)
    private  Category categoryId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Establishment.class)
    @JoinColumn(name = "ESTABLISHMENT_ID", insertable = true)
    private  Establishment establishmentId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = AgentRegistration.class)
    @JoinColumn(name = "AGENTREGISTRATION_ID", insertable = true)
    private  AgentRegistration agentRegistrationId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private  Province provinceId;

    public void setBusinessSizeId(BusinessSize businessSizeId){
        this.businessSizeId = businessSizeId;
    }

    public void setCategoryId(Category categoryId){
        this.categoryId = categoryId;
    }

    public void setEstablishmentId(Establishment establishmentId){
        this.establishmentId = establishmentId;
    }

    public void setAgentRegistrationId(AgentRegistration agentRegistrationId){
        this.agentRegistrationId = agentRegistrationId;
    }

    public void setLumpsum(String companyName,int amoungEmp,Long address,String zipCode){
        this.companyName = companyName;
        this.amoungEmp = amoungEmp;
        this.address = address;
        this.zipCode = zipCode;

    }
    public void setDate(Date date){
        this.date = date;
    }

}
