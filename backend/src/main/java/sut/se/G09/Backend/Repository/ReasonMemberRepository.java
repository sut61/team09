package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.ReasonMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReasonMemberRepository extends JpaRepository<ReasonMember, Long> {
  ReasonMember findByID(Long iD);
}