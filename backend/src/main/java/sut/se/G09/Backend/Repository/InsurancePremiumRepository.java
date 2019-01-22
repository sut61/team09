package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.InsurancePremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InsurancePremiumRepository extends JpaRepository<InsurancePremium, Long> {
  InsurancePremium findByID(Long ID);
}