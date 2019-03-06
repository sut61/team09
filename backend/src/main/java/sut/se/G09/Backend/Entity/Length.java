package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Length") //ชื่อตาราง
public class Length { //ระยะเวลาคุ้มครอง
    @Id
    @SequenceGenerator(name = "Length_seq", sequenceName = "Length_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Length_seq")
    @Column(name = "LengthId", unique = true, nullable = false, length = 100)
    private Long iD;

    @NotNull(message = "lengthName Not Null")
    private String lengthName;

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public String getlengthName() {
        return lengthName;
    }

    public void setlengthName(String lengthName) {
        this.lengthName = lengthName;
    }



public Length() {}
public Length(String lengthName){  //constructor

        this.lengthName = lengthName;
}
}