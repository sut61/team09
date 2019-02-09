package sut.se.G09.Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
@Entity  //บอกว่าเป็น class com.okta.developer.demo.Entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Table(name="ReasonMember") //ชื่อตาราง
public class ReasonMember { //เหตุผลในการยกเลิกสมาชิก


    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getReasonMemberName() {
        return reasonMemberName;
    }

    public void setReasonMemberName(String reasonMemberName) {
        this.reasonMemberName = reasonMemberName;
    }

    @Id
    @SequenceGenerator(name = "ReasonMember_seq", sequenceName = "ReasonMember_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReasonMember_seq")
    @Column(name = "ReasonMemberId", unique = true, nullable = false, length = 100)
    private Long iD;
    private String reasonMemberName;


public ReasonMember() {}
public ReasonMember(String reasonMemberName){  //constructor
    this.reasonMemberName = reasonMemberName;

	}
}