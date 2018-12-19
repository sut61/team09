package sut.sa.g26.entity;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="Protection") //ชื่อตาราง
public class Protection {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="Protection_seq",sequenceName="Protection_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Protection_seq")
@Column(name="Protection_ID",unique = true, nullable = true)
private @NonNull long id;



  public Protection(){}




  public void setProtection(String ProtectionName) {
   // this.doctorName = doctorName;

  }
}
