package edu.iu.c322.menuservice.repository;

import edu.iu.c322.menuservice.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerRepository {
    List<Customer> customers = new ArrayList<>();
    public List<Customer> findAll(){
        return customers;
    }

    public int create(Customer customer){
        int id = customers.size() + 1;
        customer.getCustomerInfo().setId(id);
        customers.add(customer);
        return id;
    }

    public void update(Customer customer, int id){
        Customer c = getById(id);
        if(c != null){
            c.getCustomerInfo().setEmail(customer.getCustomerInfo().getEmail());
            c.getCustomerInfo().setName(customer.getCustomerInfo().getEmail());
        } else {
            throw new IllegalStateException("customer with this id was not found.");
        }
    }

    private Customer getById(int id){
        Customer c = customers.stream().filter(x -> x.getCustomerInfo().getId() == id).findAny().orElse(null);
        return c;
    }

    public void delete(int id) {
        Customer c = getById(id);
        if(c != null){
            customers.remove(c);
        } else {
            throw new IllegalStateException("customer with this id was not found.");
        }
    }

}
