package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.AgentAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface AgentAppointmentRepository extends JpaRepository<AgentAppointment, Long> {
    AgentAppointment findByfName(String fName);
    AgentAppointment findBylName(String lName);
    AgentAppointment findByEmail(String email);
    AgentAppointment findByIdCardNum(String idCardNum);
    AgentAppointment deleteByIdCardNum(String idCardNum);

}