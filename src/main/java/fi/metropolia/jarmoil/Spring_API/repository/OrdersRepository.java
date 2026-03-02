package fi.metropolia.jarmoil.Spring_API.repository;

import fi.metropolia.jarmoil.Spring_API.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
