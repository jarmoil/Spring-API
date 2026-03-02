package fi.metropolia.jarmoil.Spring_API.controllers;


import fi.metropolia.jarmoil.Spring_API.repository.ContactsRepository;
import fi.metropolia.jarmoil.Spring_API.entity.Contacts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    private final ContactsRepository repository;

    public ContactsController(ContactsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contacts> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Integer id) {
        return repository.findById(Long.valueOf(id))
                .map(order -> ResponseEntity.ok(order))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contacts postContacts(@RequestBody Contacts contacts) {
        return repository.save(contacts);
    }

    @PutMapping("/{id}")
    public Contacts putContacts(@PathVariable Long id, @RequestBody Contacts contacts) {
        contacts.setId(Math.toIntExact(id));
        return repository.save(contacts);
    }

    @DeleteMapping("/{id}")
    public void deleteContacts(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
