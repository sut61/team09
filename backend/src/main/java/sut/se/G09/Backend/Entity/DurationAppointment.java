package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Entity @Data
@Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "DurationAppointment")
public class DurationAppointment {
  @Id
  @SequenceGenerator(name = "durationAppointment_seq", sequenceName = "durationAppointment_seq")
  @GeneratedValue(strategy = GenerationType   .SEQUENCE, generator = "durationAppointment_seq")
  @Column(unique = true)
  @NotNull(message="Duration ID is null")
  private Long durationId;

  @NotNull(message="Duration is null")
  @Size(max=30, message = "{Duration must less than 30 character}")
  @Pattern(regexp = "[0-9]{2}.[0-9]{2}-[0-9]{2}.[0-9]{2}\\s[น][.]")
  private String duration;

  public  DurationAppointment(){}
  public  DurationAppointment(Long durationId,String duration){
    this.durationId=durationId;
    this.duration=duration;
  }
  public Long getDurationId() {
    return durationId;
  }

  public void setDurationId(Long durationId) {
    this.durationId = durationId;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

}