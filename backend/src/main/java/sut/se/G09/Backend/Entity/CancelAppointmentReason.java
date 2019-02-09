package sut.se.G09.Backend.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity @Data
@Getter @Setter
@Table(name = "CancelAppointmentReason")
public class CancelAppointmentReason {
    @Id
    @SequenceGenerator(name = "cancelReason_seq", sequenceName = "cancelReason_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancelReason_seq")
    @NotNull(message="Reason ID is null")
    private Long reasonId;

    @NotNull(message="Reason is null")
    @Size(min=2, message = "{Reason detail must more than 1 character}")
    @Size(max=30, message = "{Reason detail must less than 30 character}")
    //@Pattern(regexp = "[\\W]+")
    private String reason;

    public String getReason() { return reason; }

    public void setReason(String reason) { this.reason = reason; }

}