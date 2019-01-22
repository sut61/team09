package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="MedicalFee") //ชื่อตาราง
public class MedicalFee {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="MedicalFee_seq",sequenceName="MedicalFee_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MedicalFee_seq")
@Column(name="MedicalFee_ID",unique = true, nullable = true)
private @NonNull long id;
private @NonNull int medicalFeeCost;


  public MedicalFee(){}




  public void setMedicalFee(int medicalFeeCost) {
    this.medicalFeeCost = medicalFeeCost;

  }
}
