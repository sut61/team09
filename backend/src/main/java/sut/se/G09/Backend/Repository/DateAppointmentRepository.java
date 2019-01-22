package com.okta.developer.demo.repository;

import com.okta.developer.demo.entity.DateAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface DateAppointmentRepository extends JpaRepository<DateAppointment, Long> {
}