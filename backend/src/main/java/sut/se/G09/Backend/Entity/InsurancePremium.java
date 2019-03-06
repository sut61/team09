package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="InsurancePremium") //ชื่อตาราง
public class InsurancePremium { //เบี้ยประกัน
    @Id
    @SequenceGenerator(name = "InsurancePremium_seq", sequenceName = "InsurancePremium_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InsurancePremium_seq")
    @Column(name = "InsurancePremiumId", unique = true, nullable = false, length = 100)
    private Long iD;

    @NotNull(message = "insuranceName Not Null")
    private String insuranceName;

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }



public InsurancePremium() {}
public InsurancePremium(String insuranceName){  //constructor
    this.insuranceName = insuranceName;

}
}