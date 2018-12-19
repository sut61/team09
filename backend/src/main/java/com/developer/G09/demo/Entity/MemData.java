package sut.sa.g09.entity;

import sut.sa.g09.entity.*;
import lombok.*;
import sut.sa.g09.repository.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode

@Table(name="MemData")
public class MemData {

 @Id
 @SequenceGenerator(name="mem_seq",sequenceName="mem_seq")
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="mem_seq")
 @Column(name = "MemID")
 private @NonNull Long id;

private String UserFName;
private String UserLName;

public MemData() {}

}
