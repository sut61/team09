package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.AgentRegistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface AgentRegistrationRepository extends JpaRepository<AgentRegistration, Long> {
  AgentRegistration findByID(Long iD);




}