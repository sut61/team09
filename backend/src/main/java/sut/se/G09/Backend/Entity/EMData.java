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
@Table(name="EMData")
public class EMData {
 @Id
 @SequenceGenerator(name="ml_seq",sequenceName="ml_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ml_seq")
 @Column(name = "EMID")
private @NonNull Long iD;
private String userName;
private String Password;


public EMData() {}


}
