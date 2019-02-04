package sut.se.G09.Backend.Entity;

import sut.se.G09.Backend.Entity.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="PaymentHistoty")
public class PaymentHistoty {

 @Id
 @SequenceGenerator(name="ph_seq",sequenceName="ph_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ph_seq")
 @Column(name = "PHID")
 private @NonNull Long iD;
 private Long amount;
 private Date date;


 @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentStatus.class)
 @JoinColumn(name = "PSID", insertable = true)
 private PaymentStatus PaymentStatus;

 @ManyToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
 @JoinColumn(name = "MID", insertable = true)
 private MemberData MemberData;



 public PaymentHistoty() {}


}
