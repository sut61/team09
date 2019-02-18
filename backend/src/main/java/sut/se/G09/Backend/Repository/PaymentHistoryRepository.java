package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.PaymentHistoty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.G09.Backend.Entity.MemberData;

import java.util.Collection;

@RepositoryRestResource
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistoty, Long> {

  PaymentHistoty findById(long Id);
  Collection<PaymentHistoty> findByMemberData (MemberData mem);
}
