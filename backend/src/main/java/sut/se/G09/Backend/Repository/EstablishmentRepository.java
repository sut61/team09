package sut.se.G09.Backend.Repository;
import com.example.demo.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{
    Establishment findByID(long id);
}
