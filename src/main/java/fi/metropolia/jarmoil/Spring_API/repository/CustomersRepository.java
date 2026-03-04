package fi.metropolia.jarmoil.Spring_API.repository;

import fi.metropolia.jarmoil.Spring_API.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    @Query("SELECT c FROM Customers c WHERE c.first_name LIKE :alku%")
    List<Customers> findByEtunimiAlkaa(@Param("alku") String alku);

}
