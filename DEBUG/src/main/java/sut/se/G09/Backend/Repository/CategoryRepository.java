package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Category findByID(Long id);
} 