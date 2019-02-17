package sut.se.G09.Backend.Entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Contact")
public class Contact {
    @Id
    @SequenceGenerator(name="contact_seq",sequenceName="contact_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="contact_seq")
    @Column(name="CONTACT_ID",unique = true, nullable = true)
    private @NonNull Long iD;
    private @NonNull String contactName;


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName){
        this.contactName = contactName;
    }
}
