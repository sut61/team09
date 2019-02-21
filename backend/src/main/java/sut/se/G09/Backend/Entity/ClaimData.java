package sut.se.G09.Backend.Entity;
import lombok.*;
import org.hibernate.validator.constraints.Range;

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



 // @Pattern(regexp = "[1-9]+[0-9]*" ,message = "Cost Include be Number")
  @Range(min = 100,max = 10000000,message = "Cost Range 100-10000000 digit")
  private long cost;

  //private @NonNull int trueCost;




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


	@ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseAccidentLevel.class)
	@JoinColumn(name = "Hospital_ID", insertable = true)
	private  Hospital hospital;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TreatmentStyle.class)
	@JoinColumn(name = "TreatmentStyle_ID", insertable = true)
	private  TreatmentStyle treatmentStyle;


	public void setTreatmentStyle(TreatmentStyle treatmentStyle) {
		this.treatmentStyle = treatmentStyle;
	}

	public void setCostClaimData(long cost) {
		this.cost = cost;


	}

		public void setMemberData (MemberData memberData){
			this.memberData = memberData;
		}

		public void setDiseaseAccidentData (DiseaseAccidentData diseaseAccidentData){
			this.diseaseAccidentData = diseaseAccidentData;
		}

		public void setCategory (Category category){
			this.category = category;}
	
		public void setHospital(Hospital hospital) {
    	this.hospital = hospital;
		}


	}
