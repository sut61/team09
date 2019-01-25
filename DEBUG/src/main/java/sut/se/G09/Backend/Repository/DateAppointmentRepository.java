package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.DateAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface DateAppointmentRepository extends JpaRepository<DateAppointment, Long> {
    DateAppointment findByDate(String date);
}