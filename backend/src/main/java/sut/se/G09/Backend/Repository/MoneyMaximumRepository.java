package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.MoneyMaximum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MoneyMaximumRepository extends JpaRepository<MoneyMaximum, Long> {
  MoneyMaximum findByID(Long id);
}