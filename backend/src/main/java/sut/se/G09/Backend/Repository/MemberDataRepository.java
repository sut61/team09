package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.MemberData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface MemberDataRepository extends JpaRepository<MemberData, Long> {

}