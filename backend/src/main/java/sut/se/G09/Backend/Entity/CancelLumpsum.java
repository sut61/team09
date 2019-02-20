package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotNull(message="Please enter Comment")
    private String comment;
    private @NonNull Date date;

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", insertable = true)
    private  Contact contactId;





    public void setComment(String comment){
        this.comment = comment;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
