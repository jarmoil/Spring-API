package fi.metropolia.jarmoil.Spring_API.service;

import fi.metropolia.jarmoil.Spring_API.dto.CustomerDto;
import fi.metropolia.jarmoil.Spring_API.entity.Customers;
import fi.metropolia.jarmoil.Spring_API.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static CustomersRepository customersRepository = null;

    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customers lisaaAsiakas(Customers customers) {
        return customersRepository.save(customers);
    }

    public CustomerDto haeCustomerDto(int id) {

        Customers customers = customersRepository.findById((long) id)
                .orElse(null);
        if (customers == null) {
            return null;
        }

        // rakenna DTO

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customers.getId());
        customerDto.setFirst_name(customers.getFirst_name());
        customerDto.setLast_name(customers.getLast_name());
        customerDto.setEmail(customers.getEmail());
        customerDto.setPhone(customers.getPhone());

        // tee ja lisää RyhmäDTO-oliot


        return customerDto;
    }

    public static List<CustomerDto> haeAsiakkaatJoidenNimiAlkaa(String alku) {

        List<Customers> customers = customersRepository.findByEtunimiAlkaa(alku);

        List<CustomerDto> dtot = new ArrayList<>();
        for (Customers h : customers) {
            CustomerDto dto = new CustomerDto(h.getId(), h.getFirst_name(), h.getLast_name(), h.getEmail(), h.getPhone());
            dtot.add(dto);
        }
        return dtot;
    }


}
