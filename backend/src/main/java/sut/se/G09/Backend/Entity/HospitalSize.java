package sut.se.G09.Backend.Entity;
import javax.persistence.*;
import lombok.*;
@Entity @Data @Getter @Setter
@Table(name = "HospitalSize")
public class HospitalSize {
    @Id @SequenceGenerator(name = "hosSize_seq", sequenceName = "hosSize_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hosSize_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)

    private Long iD;
    public HospitalSize() {}
    public HospitalSize(Long iD, String hosSize) {
        this.iD = iD;
        this.hosSize = hosSize;
    }

    private String hosSize;


    public void sethosSizeId(Long iD) { this.iD = iD; }
    public void setHosSize(String hosSize) {
        this.hosSize = hosSize;
    }

}

