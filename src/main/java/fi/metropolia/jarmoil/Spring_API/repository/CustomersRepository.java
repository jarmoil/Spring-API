package fi.metropolia.jarmoil.Spring_API.repository;

import fi.metropolia.jarmoil.Spring_API.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
