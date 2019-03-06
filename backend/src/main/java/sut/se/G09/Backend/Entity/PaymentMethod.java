package sut.se.G09.Backend.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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

@Table(name="PaymentMethod")
public class PaymentMethod {

 @Id
 @SequenceGenerator(name="pm_seq",sequenceName="pm_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pm_seq")
 @Column(name = "PMID")
 private @NonNull Long iD;
 @Column(unique = true)
 private String Method;




 public PaymentMethod() {}


}
