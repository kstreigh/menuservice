package edu.iu.c322.menuservice.controller;

import edu.iu.c322.menuservice.model.Customer;
import edu.iu.c322.menuservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000/")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {

        this.repository = repository;
    }

    // Get https:localhost:8080/customers
    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@Valid @RequestBody Customer customer) {
        Customer addedCustomer = repository.save(customer);
        return addedCustomer.getCustomerInfo().getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        Optional<Customer> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            customer.getCustomerInfo().setId(id);
            repository.save(customer);
        }
        else{
            throw new IllegalStateException("ID is not valid.");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Optional<Customer> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            repository.deleteById(id);
        }
        else{
            throw new IllegalStateException("ID is not valid");
        }
    }


}
