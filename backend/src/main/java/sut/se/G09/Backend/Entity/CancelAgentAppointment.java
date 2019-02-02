package sut.se.G09.Backend.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class CancelAgentAppointment {
    @Id
    @SequenceGenerator(name = "cancelAppointment_seq", sequenceName = "cancelAppointment_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelAppointment_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long id;

    @NotNull
    private String fName;

    @NotNull
    private String appointmentCode;
}
