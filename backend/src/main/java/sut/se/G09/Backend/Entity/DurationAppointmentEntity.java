package com.okta.developer.demo.entity;
import javax.persistence.*;
import lombok.*;

@Entity @Data
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "DurationAppointment")
public class DurationAppointment {
  @Id
  @SequenceGenerator(name = "durationAppointment_seq", sequenceName = "durationAppointment_seq")
  @GeneratedValue(strategy = GenerationType   .SEQUENCE, generator = "durationAppointment_seq")
  private Long durationId;
  private String duration;

  public  DurationAppointment(){}
}