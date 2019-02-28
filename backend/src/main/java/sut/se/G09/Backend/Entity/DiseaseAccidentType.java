package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="Type") //ชื่อตาราง
public class DiseaseAccidentType {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="DiseaseAccidentType_seq",sequenceName="DiseaseAccidentType_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DiseaseAccidentType_seq")
@Column(name="Type_ID",unique = true, nullable = true)
private @NonNull long id;

  @NotNull(message = "typeText Not Null")
private String typeText;


  public DiseaseAccidentType(){}




  public void setDiseaseAccidentType(String typeText) {
    this.typeText = typeText;

  }
}
