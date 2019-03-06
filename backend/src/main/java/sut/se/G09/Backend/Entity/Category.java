package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Category") //ชื่อตาราง
public class Category { //ประเภทประกัน
    @Id
    @SequenceGenerator(name = "Category_seq", sequenceName = "Category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_seq")
    @Column(name = "CategoryId", unique = true, nullable = false, length = 100)
    private Long iD;

    @NotNull(message="Please enter Category name")
    @Pattern(regexp = "^[A-z]*[ก-๐]+|^[ก-๐]*[A-z]+")
    @Size(max = 20)
    @Size(min = 6)
    @Column( unique = true)
    private String typeName; //กรอกชื่อประเภทประกัน

    @NotNull(message="Please enter oFName name")
    @Size(max = 20)
    @Size(min = 2)
    private String oFName; //กรอกชื่อคนเพิ่มประเภท

    @NotNull(message="Please enter oLName name")
    @Size(max = 20)
    @Size(min = 2)
    private String oLName; //กรอกนามสกุลคนเพิ่มประเภท

    @NotNull(message="Please enter oTlePhone name")
    @Pattern(regexp = "[0]{1}[2-9]{1}[0-9]{8}" , message = "{Telephone number pattern is invalid}")
    private String oTlePhone; //เบอร์โทรคนเพิ่มประเภท

    @NotNull(message="Please enter typeNameReason name")
    private String typeNameReason;  //หมายเหตุ
    private Date date; //วันที่ทำการเพิ่ม

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName; }
    public String getoFName() {
        return oFName;
    }

    public void setoFName(String oFName) {
        this.oFName = oFName;
    }

    public String getoLName() {
        return oLName;
    }

    public void setoLName(String oLName) {
        this.oLName = oLName;
    }
    public String getoTlePhone() {
        return oTlePhone;
    }

    public void setoTlePhone(String oTlePhone) {
        this.oTlePhone = oTlePhone;
    }

    public String getTypeNameReason() {
        return typeNameReason;
    }

    public void setTypeNameReason(String typeNameReason) {
        this.typeNameReason = typeNameReason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date; }

    @NotNull(message = "InsurancePremium not Null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = InsurancePremium.class)
    @JoinColumn(name = "InsurancePremiumId", insertable = true)
    private  InsurancePremium insurancePremium;

    @NotNull(message = "Length not Null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Length.class)
    @JoinColumn(name = "LengthId", insertable = true)
    private  Length length;

    @NotNull(message = "MoneyMaximum not Null")
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MoneyMaximum.class)
    @JoinColumn(name = "MoneyMaximumId", insertable = true)
    private  MoneyMaximum moneyMaximum;

public Category(){}
public Category(String typeName,
                String oFName,
                String oLName,
                String oTlePhone,
                String typeNameReason,
                Date date){  //constructor
    this.typeName = typeName;
    this.oFName = oFName;
    this.oLName = oLName;
    this.oTlePhone = oTlePhone;
    this.typeNameReason = typeNameReason;
     this.date = date;
    }
}