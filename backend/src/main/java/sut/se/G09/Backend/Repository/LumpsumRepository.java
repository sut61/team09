package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.Lumpsum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface LumpsumRepository extends JpaRepository<Lumpsum, Long>{
    Lumpsum findByID (Long id);
    Lumpsum deleteByID (Long id);
}
