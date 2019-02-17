package sut.se.G09.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sut.se.G09.Backend.Entity.Contact;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact , Long> {
    Contact findByContactName (String contactName);
    Contact findByID (Long id);
}
