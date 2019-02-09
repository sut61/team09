package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.CancelInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CancelInsuranceRepository extends JpaRepository<CancelInsurance, Long> {
  CancelInsurance findByID(Long iD);
}