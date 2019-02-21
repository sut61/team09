package sut.se.G09.Backend.Entity;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @NotNull(message="Comment is null")
    private String comment;

    private @NonNull Date date;

    @NotNull(message="Name is null")
    @Size(max=50, message = "{First name length must less than 50 character}")
    private String nameCan;

    @NotNull(message="Age is null")
    @Range(min=20, max=80, message = "{Age Must between 20-80 years old}")
    private Integer ageCan;

    @NotNull(message="{ID card number is null}")
    @Pattern(regexp = "[0-9]{13}", message = "{ID card number pattern is invalid}")
    private String IDcardCan;

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Contact.class)
    @JoinColumn(name = "CONTACT_ID", insertable = true)
    private  Contact contactId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "PROVINCE_ID", insertable = true)
    private  Province provinceId;

    public void setProvinceId(Province provinceId){
        this.provinceId = provinceId;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setNameCan(String nameCan) {
        this.nameCan = nameCan;
    }

    public void setAgeCan(Integer ageCan) {
        this.ageCan = ageCan;
    }

    public void setIDcardCan(String IDcardCan) {
        this.IDcardCan = IDcardCan;
    }

    public void setDate(Date date){
        this.date = date;
    }
}
