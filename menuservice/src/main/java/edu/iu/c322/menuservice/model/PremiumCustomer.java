package edu.iu.c322.menuservice.model;

public class PremiumCustomer extends Customer{
    CustomerFactory customerFactory;

    public PremiumCustomer(CustomerFactory customerFactory){
        this.customerFactory = customerFactory;
    }

    @Override
    void createCustomer() {
        customerInfo = customerFactory.createCustomerInfo();
        payment = customerFactory.createPayment();
        address = customerFactory.createAddress();
    }
}
