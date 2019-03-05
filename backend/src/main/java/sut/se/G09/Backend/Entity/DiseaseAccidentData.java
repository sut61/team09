package sut.se.G09.Backend.Entity;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="DiseaseAccidentData") //ชื่อตาราง
public class DiseaseAccidentData {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="DiseaseAccidentData_seq",sequenceName="DiseaseAccidentData_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DiseaseAccidentData_seq")
@Column(name="DiseaseAccidentData_ID",unique = true, nullable = true)
private @NonNull long id;

  @NotNull(message="Please enter Disease/Accident")
  @Column(unique = true)
  @Pattern(regexp = "^[^a-zA-Z]+$|^[0-9]+$",message = "Please not enter English")
  @Size(min = 3,max = 50,message = "Please not enter data in 3-50 digit")
    private String dataName;

    public void  setDataOwner(String ownerD){this.dataOwner = ownerD;}

    @Pattern(regexp = "^[^a-zA-Z]+$|^[0-9]+$",message = "Please not enter English")
    @NotNull(message = "Please enter Owner")
    private String dataOwner;



  public DiseaseAccidentData(){}

  @NotNull(message="Please enter DiseaseAccidentLevel")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentLevel.class)
  @JoinColumn(name = "Level_ID", insertable = true)
  private  DiseaseAccidentLevel diseaseAccidentLevel;

  @NotNull(message="Please enter DiseaseAccidentType")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentType.class)
  @JoinColumn(name = "Type_ID", insertable = true)
  private  DiseaseAccidentType diseaseAccidentType;

  @NotNull(message="Please enter MedicalFee")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MedicalFee.class)
  @JoinColumn(name = "MedicalFee_ID", insertable = true)
  private  MedicalFee medicalFee;


	public void setDiseaseAccidentData(String dataName) {
    this.dataName = dataName;
	}

	
	public void setDiseaseAccidentLevel(DiseaseAccidentLevel diseaseAccidentLevel) {
    this.diseaseAccidentLevel = diseaseAccidentLevel;
	}
	
	public void setDiseaseAccidentType(DiseaseAccidentType diseaseAccidentType) {
    this.diseaseAccidentType = diseaseAccidentType;
	}
	
	public void setMedicalFee(MedicalFee medicalFee) {
    this.medicalFee = medicalFee;
	}




}
