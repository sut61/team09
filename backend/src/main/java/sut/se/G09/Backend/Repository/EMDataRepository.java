package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.EMData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface EMDataRepository extends JpaRepository<EMData, Long> {
    EMData findByUserName(String MLData);
}


