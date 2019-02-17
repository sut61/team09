package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CancelLumpsum")
public class CancelLumpsum {
    @Id
    @SequenceGenerator(name="cancellumpsum_seq",sequenceName="canclelumpsum_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cancellumpsum_seq")
    @Column(name="CANCELLUMPSUM_ID",unique = true, nullable = true)
    private @NonNull Long iD;
    private @NonNull String comment;
    private @NonNull Date date;



    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    public void setLumpsumId(Lumpsum lumpsumId) {
        this.lumpsumId = lumpsumId;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", insertable = true)
    private  Contact contactId;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = Lumpsum.class)
    @JoinColumn(name = "LUMPSUM_ID")
    private  Lumpsum lumpsumId;



    public void setComment(String comment){
        this.comment = comment;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
