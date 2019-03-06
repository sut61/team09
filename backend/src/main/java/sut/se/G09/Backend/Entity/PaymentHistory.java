package sut.se.G09.Backend.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import sut.se.G09.Backend.Entity.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="PaymentHistory")
public class PaymentHistory {

 @Id
 @SequenceGenerator(name="ph_seq",sequenceName="ph_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ph_seq")
 @Column(name = "PHID")
 @NotNull
 private  Long iD;

 @NotNull
 @Column(unique = true)
 @Size(min = 8 , max = 8)
 private String code;

 @NotNull
 @Pattern(regexp = "[0-9]+")
 @Size(min = 10 , max = 10)
 private String CardNumber;

 @NotNull
 @Pattern(regexp = "[0-9]+")
 @Size(min = 2 , max = 2)
 private String CardEXP;

 @NotNull
 private Long amount;
 @NotNull
 private Date date;


 @NotNull
 @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JoinColumn(name = "MID", insertable = true)
 private MemberData memberData;

 @NotNull
 @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentMethod.class)
 @OnDelete(action = OnDeleteAction.CASCADE)
 @JoinColumn(name = "PMID", insertable = true)
 private PaymentMethod PaymentMethod;


 public PaymentHistory() {}


}
