package sut.se.G09.Backend.Repository;
import com.example.demo.entity.BusinessSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BusinessSizeRepository extends JpaRepository<BusinessSize, Long>{
    BusinessSize findByID(long id);
}
