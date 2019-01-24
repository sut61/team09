package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.MLData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MLDataRepository extends JpaRepository<MLData, Long> {
    MLData findByUserName(String MLData);
}


