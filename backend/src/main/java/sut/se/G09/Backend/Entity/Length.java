package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="Length") //ชื่อตาราง
public class Length {
    @Id
    @SequenceGenerator(name = "Length_seq", sequenceName = "Length_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Length_seq")
    @Column(name = "LengthId", unique = true, nullable = false, length = 100)
    private Long iD;
    private Long lengthName;

    public Long getId() {
        return iD;
    }

    public void setId(Long id) {
        this.iD = id;
    }

    public Long getlengthName() {
        return lengthName;
    }

    public void setlengthName(Long lengthName) {
        this.lengthName = lengthName;
    }



protected Length() {}
public Length(Long lengthName){  //constructor

        this.lengthName = lengthName;
}
}