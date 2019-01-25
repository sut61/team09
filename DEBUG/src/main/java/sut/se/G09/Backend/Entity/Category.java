package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.ManyToOne;
import java.util.Date;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Category") //ชื่อตาราง
public class Category {
    @Id
    @SequenceGenerator(name = "Category_seq", sequenceName = "Category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Category_seq")
    @Column(name = "CategoryId", unique = true, nullable = false, length = 100)
    private Long iD;
    private String typeName;
    private Date date; //วันที่ทำการเพิ่ม

    /*
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date; }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = InsurancePremium.class)
    @JoinColumn(name = "InsurancePremiumId", insertable = true)
    private  InsurancePremium insurancePremium;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Length.class)
    @JoinColumn(name = "LengthId", insertable = true)
    private  Length length;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MoneyMaximum.class)
    @JoinColumn(name = "MoneyMaximumId", insertable = true)
    private  MoneyMaximum moneyMaximum;

    public Category(){}
    public Category(String typeName, Date date){  //constructor
        this.typeName = typeName;
        this.date = date;
    } */
}