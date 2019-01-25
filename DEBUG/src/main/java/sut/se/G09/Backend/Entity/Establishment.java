package sut.se.G09.Backend.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import  java.util.*;
import  java.sql.Timestamp;
@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="Establishment") //ชื่อตาราง

public class Establishment {
    @Id
    @SequenceGenerator(name="establishment_seq",sequenceName="establishment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="establishment_seq")
    @Column(name="ESTABLISHMENT_ID",unique = true, nullable = true)
    private @NonNull Long  iD;
    private String estabName;

    public void setEstabName(String estabName){
        this.estabName = estabName;
    }
}
