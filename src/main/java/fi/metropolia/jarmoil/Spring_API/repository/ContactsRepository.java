package fi.metropolia.jarmoil.Spring_API.repository;

import fi.metropolia.jarmoil.Spring_API.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
