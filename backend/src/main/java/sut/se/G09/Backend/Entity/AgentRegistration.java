package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "AgentRegistration", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class AgentRegistration {
  @Id
  @SequenceGenerator(name = "Aregist_seq", sequenceName = "Aregist_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Aregist_seq")
  @Column(name = "ID", unique = true, nullable = false, length = 100)
  private Long iD;



  private String fName;
  private String lName;

  public AgentRegistration(){}
  public void setAgentRegistration( String fName,String lName) {

    this.fName = fName;
    this.lName = lName;
  }


  public void setfName(String eduId) {
    this.fName = fName;
  }
  public void setlName(String eduId) {
    this.lName = lName;
  }


  @ManyToOne
  @JoinColumn(name= "education_id")
  private Educational educational;

  @ManyToOne
  @JoinColumn(name= "province_id")
  private Province province;

  @ManyToOne
  @JoinColumn(name= "Category_id")
  private Category category;

  public void setEducational(Educational educational) { this.educational = educational;
  }

  public void setProvince(Province province) {this.province = province;
  }

  public void setCategory(Category category) {this.category = category;
  }

}