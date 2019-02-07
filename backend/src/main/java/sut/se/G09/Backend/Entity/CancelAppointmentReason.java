package sut.se.G09.Backend.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Data
@Table(name = "CancelAppointmentReason")
public class CancelAppointmentReason {
    @Id
    @SequenceGenerator(name = "cancelReason_seq", sequenceName = "cancelReason_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelReason_seq")
    private Long reasonId;

    @NotNull
    private String reason;

}