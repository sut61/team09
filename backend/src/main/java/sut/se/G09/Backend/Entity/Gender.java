package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;
import java.util.*;
@Entity @Data @Getter @Setter 
@Table(name = "Gender")
public class Gender {
  @Id @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")
  @Column(unique = true)
  private Long genderId;

  @NotNull(message="{Gender is null}")
  private String genderName;

  public Gender() { }
  public void setGenderId(Long genderId) { this.genderId = genderId; }
  public void setGenderName(String genderName) {
    this.genderName = genderName;
  }

}