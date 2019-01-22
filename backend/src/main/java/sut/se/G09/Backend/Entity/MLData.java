package sut.se.g09.backend.entity;

import sut.se.g09.backend.entity.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="MLData")
public class MLData {

 @Id
 @SequenceGenerator(name="ml_seq",sequenceName="ml_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ml_seq")
 @Column(name = "MLID")
private @NonNull Long id;
private String UserName;
private String Password;




public MLData() {}


}
