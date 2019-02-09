package sut.se.G09.Backend.Entity;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter

@ToString
@Table(name="ClaimData") //ชื่อตาราง
public class ClaimData {

  @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
@SequenceGenerator(name="ClaimData_seq",sequenceName="ClaimData_seq")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ClaimData_seq")
@Column(name="ClaimData_ID",unique = true, nullable = true)
private @NonNull long id;


  @NotNull(message = "Cost Not null")
  @Pattern(regexp = "[^0]{1}[0-9]*" ,message = "Cost Include be Number")
  @Size(min = 1,max = 8,message = "Cost Size 1-8 digit")
  private String cost;

  private @NonNull int trueCost;




  public ClaimData(){}
  
	//-----------------[ดึงชื่อคนใช้สิทธิ์]-------------------
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
	@JoinColumn(name = "MemberData_ID", insertable = true)
	private  MemberData memberData;

  //-------------[ดึงโรค/อุบัติเหตุ]----------------------
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentData.class)
	@JoinColumn(name = "DiseaseAccident_ID", insertable = true)
	private  DiseaseAccidentData diseaseAccidentData;
	
  //-----------------[ดึงประกัน]-------------------
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
	@JoinColumn(name = "Category_ID", insertable = true)
	private  Category category;

/*/-----------------[โรงพยาบาล]-------------------
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentLevel.class)
	@JoinColumn(name = "Hospital_ID", insertable = true)
	private  DiseaseAccidentLevel diseaseAccidentLevel;
	---------------------------------------------------------------*/
	
	public void setCostClaimData(String cost) {
		this.cost = cost;
		trueCost = Integer.valueOf(cost);

	}

		public void setMemberData (MemberData memberData){
			this.memberData = memberData;
		}

		public void setDiseaseAccidentData (DiseaseAccidentData diseaseAccidentData){
			this.diseaseAccidentData = diseaseAccidentData;
		}

		public void setCategory (Category category){
			this.category = category;}
	
	/*
	
	public void setHospital(MedicalFee medicalFee) {
    this.medicalFee = medicalFee;
	}
	*/

	}
