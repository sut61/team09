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

@Table(name="PaymentStatus")
public class PaymentStatus {

 @Id
 @SequenceGenerator(name="ps_seq",sequenceName="ps_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ps_seq")
 @Column(name = "PSID")
 private @NonNull Long iD;
 private String status;




 public PaymentStatus() {}


}
