package fi.metropolia.jarmoil.Spring_API.repository;

import fi.metropolia.jarmoil.Spring_API.entity.Customeraddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomeraddressesRepository extends JpaRepository<Customeraddresses, Long> {
}
