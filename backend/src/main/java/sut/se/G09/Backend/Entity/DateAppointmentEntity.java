package com.okta.developer.demo.entity;
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
}