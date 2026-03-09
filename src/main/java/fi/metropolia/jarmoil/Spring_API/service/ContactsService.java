package fi.metropolia.jarmoil.Spring_API.service;

import fi.metropolia.jarmoil.Spring_API.dto.ContactsDto;
import fi.metropolia.jarmoil.Spring_API.entity.Contacts;
import fi.metropolia.jarmoil.Spring_API.repository.ContactsRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactsService {

    private final ContactsRepository contactsRepository;

    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public ContactsDto haeContactsDto(int id) {
        Contacts contacts = contactsRepository.findById(Long.valueOf(id)).orElse(null);
        if (contacts == null) {
            return null;
    }

        ContactsDto contactsDto = new ContactsDto();
        contactsDto.setId((int) contacts.getId());
        contactsDto.setEmail(contacts.getEmail());
        contactsDto.setReference(contacts.getReference());

        if (contacts.isVoimassa()) {
            System.out.println("Huomio: kontakti " + contacts.getId() + " on voimassa!");
        }

        return contactsDto;
    }

}
