package com.okta.developer.demo.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity @Data @Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "AgentAppointment", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID")})
public class AgentAppointment {

}