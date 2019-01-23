package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;

@Entity @Data
@Getter @Setter
@Table(name = "DateAppointment")
public class DateAppointment {
  @Id
  @SequenceGenerator(name = "dateAppointment_seq", sequenceName = "dateAppointment_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dateAppointment_seq")
  private Long dateId;
  private String date;
  private int dateCount;
  private String dateStatus;

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

  public int getDateCount() {
    return dateCount;
  }

  public void setDateCount(int dateCount) {
    this.dateCount = dateCount;
  }

  public String getDateStatus() {
    return dateStatus;
  }

  public void setDateStatus(String dateStatus) {
    this.dateStatus = dateStatus;
  }
}