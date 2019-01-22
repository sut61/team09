package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity @Data @Getter @Setter 
@Table(name = "Sex")
public class Sex {
  @Id @SequenceGenerator(name = "sex_seq", sequenceName = "sex_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sexs_seq")
  @Column(name = "ID", unique = true, nullable = false, length = 100)
  
  private Long sexId;
  private String sexName;

  public Sex() { }

}