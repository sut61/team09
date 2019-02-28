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
  private Long dateId;

  @NotNull(message="{Date is null}")
  private String date;

  @NotNull(message="{Count is null}")
  @Range(min=0, max=4, message = "{Date Appoint Limit at 4 times/date}")
  private Integer count=0;

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

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}