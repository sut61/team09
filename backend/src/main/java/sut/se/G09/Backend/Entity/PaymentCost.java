package sut.se.G09.Backend.Entity;

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

@Table(name="PaymentCost")
public class PaymentCost {

 @Id
 @SequenceGenerator(name="ph_seq",sequenceName="ph_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ph_seq")
 @Column(name = "PCID")
 private @NonNull Long iD;

 @NotNull
 @Column(unique = true)
 @Size(min = 8 , max = 8)
 private String code;

 @NotNull
 private Long amount;
 @NotNull
 private Date date;



 @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
 @JoinColumn(name = "MID", insertable = true)
 private MemberData memberData;



 public PaymentCost () {}


}
