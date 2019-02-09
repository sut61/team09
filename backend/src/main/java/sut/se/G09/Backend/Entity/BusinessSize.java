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
@Table(name="BusinessSize") //ชื่อตาราง
public class BusinessSize {
    @Id
    @SequenceGenerator(name="business_seq",sequenceName="business_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="business_seq")
    @Column(name="BUSINESS_ID",unique = true, nullable = true)
    private @NonNull Long  iD;
    private String sizeName;

    public void setSize(String sizeName){
        this.sizeName = sizeName;
    }
}
