package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity @Data @Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "AgentRegistration", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")})
public class AgentRegistration {


  @Id @SequenceGenerator(name = "Aregist_seq", sequenceName = "Aregist_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Aregist_seq")
  @Column(name = "ID", unique = true, nullable = false, length = 100)
  private Long iD;

  @Column( unique = true)
  @NotNull(message="{First name is null}")
  @Size(min=2, message = "{First name length must more than 1 character}")
  @Size(max=30, message = "{First name length must less than 30 character}")

  private String fName;
  @Column( unique = true)
  @NotNull(message="{Last name is null}")
  @Size(min=2, message = "{Last name length must more than 1 character}")
  @Size(max=30, message = "{Last name length must less than 30 character}")
  private String lName;

  public AgentRegistration(){}
  public void setAgentRegistration( String fName,String lName) {

    this.fName = fName;
    this.lName = lName;
  }


  public void setfName(String fName) {
    this.fName = fName;
  }
  public void setlName(String lName) {
    this.lName = lName;
  }
  public void setiD(Long iD) { this.iD = iD; }

  @NotNull(message="Educational not be null")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Educational.class)
  @JoinColumn(name= "education_id")
  private Educational educational;

  @NotNull(message="Province not be null")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
  @JoinColumn(name= "province_id")
  private Province province;

  @NotNull(message="Category not be null")
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
  @JoinColumn(name= "Category_id")
  private Category category;

  public void setEducational(Educational educational) { this.educational = educational;
  }

  public void setProvince(Province province) {this.province = province;
  }

  public void setCategory(Category category) {this.category = category;
  }

}