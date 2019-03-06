package sut.se.G09.Backend.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

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

    @NotNull(message="Company Name can be null")
    @Column(unique = true)
    private String companyName;

    @NotNull(message="among of Employee can be null")
    @Range(min=5, max=10000000)
    private Integer amoungEmp;

    @NotNull(message="address can be null")
    @Pattern(regexp = "[0-9\\d]{1,3}\\W.{1,20}\\W.{1,20}")
    private String address;

    @NotNull(message="zipCode can be null")
    @Size(min = 5 , max = 5)
    private String zipCode;

    @NotNull(message="Date can be null")
    private Date date;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BusinessSize.class)
    @JoinColumn(name = "BUSINESS_ID", insertable = true)
    private @NotNull BusinessSize businessSizeId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID", insertable = true)
    private @NotNull Category categoryId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Establishment.class)
    @JoinColumn(name = "ESTABLISHMENT_ID", insertable = true)
    private @NotNull Establishment establishmentId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private @NotNull Province provinceId;

    public void setBusinessSizeId(BusinessSize businessSizeId){
        this.businessSizeId = businessSizeId;
    }

    public void setCategoryId(Category categoryId){
        this.categoryId = categoryId;
    }

    public void setEstablishmentId(Establishment establishmentId){
        this.establishmentId = establishmentId;
    }

    public void setProvinceId(Province provinceId){
        this.provinceId = provinceId;
    }

    public void setiD(Long iD){this.iD = iD;}

    public void setLumpsum(String companyName, Integer amoungEmp, String address, String zipCode){
        this.companyName = companyName;
        this.amoungEmp = amoungEmp;
        this.address = address;
        this.zipCode = zipCode;

    }

    public Long getiD() {
        return iD;
    }

    public void setDate(Date date){
        this.date = date;
    }

}
