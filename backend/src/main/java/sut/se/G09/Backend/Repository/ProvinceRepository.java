package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.Province;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByID(Long Province);
}


