package sut.se.G09.Backend.Entity;

import sut.se.G09.Backend.Entity.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="MemberData")
public class MemberData {

 @Id
 @SequenceGenerator(name="mem_seq",sequenceName="mem_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mem_seq")
 @Column(name = "MID")
 private @NonNull Long iD;

private String Fname;
private String Lname;
private Long age;
private String IDCard;


 @ManyToOne(fetch = FetchType.EAGER, targetEntity = MLData.class)
 @JoinColumn(name = "MLID", insertable = true)
 private MLData MLData;
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
 @JoinColumn(name = "PROVINCE_ID", insertable = true)
 private Province Province;
 
   @ManyToOne(fetch = FetchType.EAGER, targetEntity = AgentRegistration.class)
 @JoinColumn(name = "ID", insertable = true)
 private AgentRegistration AgentRegistration;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class)
 @JoinColumn(name = "CategoryID", insertable = true)
 private Category Category;




public MemberData() {}


}
