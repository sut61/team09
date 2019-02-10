package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.MemberData;
import sut.se.G09.Backend.Entity.PaymentCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentCostRepository extends JpaRepository<PaymentCost, Long> {

  PaymentCost findById(long Id);
  PaymentCost deleteByCode(String Code);
  PaymentCost findByCode(String code);
  PaymentCost findByMemberData (MemberData mem);
}
