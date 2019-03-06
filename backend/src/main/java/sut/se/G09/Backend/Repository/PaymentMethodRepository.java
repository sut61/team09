package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

  PaymentMethod findById(long Id);
}
