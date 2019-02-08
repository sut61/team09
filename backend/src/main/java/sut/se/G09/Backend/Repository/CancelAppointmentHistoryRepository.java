package sut.se.G09.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.G09.Backend.Entity.CancelAppointmentHistory;

@RepositoryRestResource
public interface CancelAppointmentHistoryRepository extends JpaRepository<CancelAppointmentHistory, Long> {

}