package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;
import org.hibernate.validator.constraints.Range;

@Entity @Data
@Getter @Setter
@Table(name = "DateAppointment")
public class DateAppointment {
  @Id
  @SequenceGenerator(name = "dateAppointment_seq", sequenceName = "dateAppointment_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dateAppointment_seq")
  @Column(unique = true)
  @NotNull(message="Date ID is null")
  private Long dateId;

  @NotNull(message="{Date is null}")
  //@Pattern(regexp = "[1-3]{1}[0-9]*\\s[\\W]+\\s[0-9]{4}")
  private String date;

  @NotNull(message="{Count is null}")
  @Range(min=0, max=4, message = "{Date Appoint Limit at 0-4 times/date}")
  private int count=0;

  @NotNull(message="{Status is null}")
  @Pattern(regexp = "[a-z]+")
  private String status="available";


  public  DateAppointment(){}
  public  DateAppointment(Long dateId,String date){
    this.dateId=dateId;
    this.date=date;
  }
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}