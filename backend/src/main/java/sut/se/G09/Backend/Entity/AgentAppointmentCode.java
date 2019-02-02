package sut.se.G09.Backend.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class AgentAppointmentCode {
    @Id
    @SequenceGenerator(name = "appointmentCode_seq", sequenceName = "appointmentCode_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointmentCode_seq")
    @Column(name = "ID", unique = true, nullable = false, length = 100)
    private Long codeId;

    @NotNull
    private String code;
}
