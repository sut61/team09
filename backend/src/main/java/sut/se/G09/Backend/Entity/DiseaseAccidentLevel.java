package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="Level") //ชื่อตาราง
public class DiseaseAccidentLevel {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="DiseaseAccidentLevel_seq",sequenceName="DiseaseAccidentLevel_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DiseaseAccidentLevel_seq")
@Column(name="Level_ID",unique = true, nullable = true)
private @NonNull long id;

  @NotNull(message = "levelText Not Null")
private String levelText;


  public DiseaseAccidentLevel(){}




  public void setLevelText(String levelText) {
    this.levelText = levelText;

  }
}
