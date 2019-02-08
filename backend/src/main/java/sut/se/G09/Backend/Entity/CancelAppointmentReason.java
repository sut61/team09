package sut.se.G09.Backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Data
@Getter @Setter
@Table(name = "CancelAppointmentReason")
public class CancelAppointmentReason {
    @Id
    @SequenceGenerator(name = "cancelReason_seq", sequenceName = "cancelReason_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelReason_seq")
    private Long reasonId;

    private String reason;

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

}