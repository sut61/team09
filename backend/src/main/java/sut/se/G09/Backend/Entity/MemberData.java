package sut.se.G09.Backend.Entity;

import sut.se.G09.Backend.Entity.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
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

 @NotNull
 @Pattern(regexp = "^[^0-9]+$")
 @Size(min = 2,max = 20)
 private String Fname;

 @NotNull
 @Size(min = 2,max = 20)
 @Pattern(regexp = "^[^0-9]+$")
 private String Lname;

 @NotNull
 //@Pattern(regexp = "[1-8]{0,1}[0-9]{1}|[9]{1}[0]{1}")
 private Long age;

 @Pattern(regexp = "[0-9]+")
 @Column(unique = true)
 @Size(min = 13,max = 13)
 @NotNull
 private String idCard;

 @NotNull
 private String addess;


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
