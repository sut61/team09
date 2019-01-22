package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity @Data @Getter @Setter 
@Table(name = "Gender")
public class Gender {
  @Id @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")
  @Column(name = "ID", unique = true, nullable = false, length = 100)
  
  private Long genderId;
  private String genderName;

  public Gender() { }

}