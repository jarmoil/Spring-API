package fi.metropolia.jarmoil.Spring_API.controllers;


import fi.metropolia.jarmoil.Spring_API.dto.CustomerDto;
import fi.metropolia.jarmoil.Spring_API.entity.Customers;
import fi.metropolia.jarmoil.Spring_API.repository.CustomersRepository;
import fi.metropolia.jarmoil.Spring_API.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomersRepository repository;

    public CustomersController(CustomersRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer id) {
        return repository.findById(Long.valueOf(id))
                .map(customer -> ResponseEntity.ok(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/etunimi/{alku}")
    public ResponseEntity<List<CustomerDto>> getCustomerEtunimiAlkaa(@PathVariable String alku){
        List<CustomerDto> customers = CustomerService.haeAsiakkaatJoidenNimiAlkaa(alku);
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public Customers postCustomer(@RequestBody Customers customer) {
        return repository.save(customer);
    }

    @PutMapping("/{id}")
    public Customers putCustomer(@PathVariable Long id, @RequestBody Customers customer) {
        customer.setId(Math.toIntExact(id));
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
