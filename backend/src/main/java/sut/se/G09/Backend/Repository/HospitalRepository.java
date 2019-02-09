package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface HospitalRepository extends JpaRepository<Hospital, Long>{
    Hospital findByID(long iD);
    Hospital findByHosName(String hosName);
}