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
@Table(name="CancelInsurance") //ชื่อตาราง
public class CancelInsurance { //ยกเลิกประกันชีวิต
    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTlePhone() {
        return tlePhone;
    }

    public void setTlePhone(String tlePhone) {
        this.tlePhone = tlePhone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ReasonMember getReasonMember() {
        return reasonMember;
    }

    public void setReasonMember(ReasonMember reasonMember) {
        this.reasonMember = reasonMember;
    }

    @Id
    @SequenceGenerator(name = "CancelInsurance_seq", sequenceName = "CancelInsurance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CancelInsurance_seq")
    @Column(name = "CancelInsuranceId", unique = true, nullable = false, length = 100)

    private Long iD;

    @NotNull(message="Please enter First name")
    @Pattern(regexp = "[0-9]{13}")
    @Column( unique = true)
    private String idCard;

    @NotNull(message="Please enter First name")
    @Pattern(regexp = "^[A-z]*[ก-๐]{2,20}|^[ก-๐]*[A-z]{2,20}")
    private String fName;

    @NotNull(message="Please enter First name")
    @Pattern(regexp = "^[A-z]*[ก-๐]{2,20}|^[ก-๐]*[A-z]{2,20}")
    private String lName;

    @NotNull(message="Please enter First name")
    @Pattern(regexp = "[A-Za-z0-9][A-Za-z0-9.]{5}[A-Za-z0-9.]*@[a-z]+.[a-z.]+")
    private String eMail;

    @NotNull(message="Please enter First name")
    @Pattern(regexp = "[0]{1}[6,8,9]{1}[0-9]{8}")
    private String tlePhone;
    private Date date; //วันที่ทำการยกเลิก

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ReasonMember.class)
    @JoinColumn(name = "ReasonMemberId", insertable = true)
    private  ReasonMember reasonMember;

public CancelInsurance(){}
public CancelInsurance(String idCard,String fName,String lName,String eMail,
                       String tlePhone, Date date){  //constructor
    this.idCard = idCard;
    this.fName = fName;
    this.lName = lName;
    this.eMail = eMail;
    this.tlePhone = tlePhone;
    this.date = date;
    }
}