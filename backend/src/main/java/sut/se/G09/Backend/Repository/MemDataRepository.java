package sut.se.g09.backend.repository;

import sut.se.g09.backend.repository.entity.MemberData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MemDataRepository extends JpaRepository<MemData, Long> {

}