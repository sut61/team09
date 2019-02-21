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
@Table(name="MLData")
public class MLData {
 @Id
 @SequenceGenerator(name="ml_seq",sequenceName="ml_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ml_seq")
 @Column(name = "MLID")
private @NonNull Long iD;
 @Column(unique = true)
private String userName;
private String Password;


 @OneToOne(fetch = FetchType.EAGER, targetEntity = MemberData.class)
 @JoinColumn(name = "MID", insertable = true)
 private MemberData memberData;

public MLData() {}


}
