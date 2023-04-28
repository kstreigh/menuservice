package edu.iu.c322.menuservice.model;

public class DefaultCustomer extends Customer{
    CustomerFactory customerFactory;

    public DefaultCustomer(CustomerFactory customerFactory){
        this.customerFactory = customerFactory;
    }

    @Override
    void createCustomer() {
        customerInfo = customerFactory.createCustomerInfo();
        payment = customerFactory.createPayment();
        address = customerFactory.createAddress();
    }
}
