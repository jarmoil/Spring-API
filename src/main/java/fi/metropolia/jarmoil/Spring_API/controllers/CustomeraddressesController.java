package fi.metropolia.jarmoil.Spring_API.controllers;


import fi.metropolia.jarmoil.Spring_API.entity.Customeraddresses;
import fi.metropolia.jarmoil.Spring_API.repository.CustomeraddressesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customeraddresses")
public class CustomeraddressesController {

    private final CustomeraddressesRepository repository;

    public CustomeraddressesController(CustomeraddressesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Customeraddresses> getCustomeraddresses(@PathVariable String id) {
        return repository.findById(Long.valueOf(id))
                .map(customeraddresses -> ResponseEntity.ok(customeraddresses))
                .orElse(ResponseEntity.notFound().build());
    }


}
