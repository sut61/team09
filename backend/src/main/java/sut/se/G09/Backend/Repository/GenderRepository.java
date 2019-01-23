package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Gender findByGenderId(Long genderId);
}