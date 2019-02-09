package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.HospitalSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface HospitalSizeRepository extends JpaRepository<HospitalSize, Long>{
    HospitalSize findByID(long iD);
    HospitalSize findByHosSize(String hosSize);

}