package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DiseaseAccidentTypeRepository extends JpaRepository<DiseaseAccidentType, Long> {

  DiseaseAccidentType findById(long Id);
  DiseaseAccidentType findByTypeText(String TypeText);

}
