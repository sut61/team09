package sut.se.g09.backend.repository;

import sut.sa.g09.backend.entity.MLData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MLDataRepository extends JpaRepository<MLData, Long> {
    MLData findByID(Long MLData);
}


