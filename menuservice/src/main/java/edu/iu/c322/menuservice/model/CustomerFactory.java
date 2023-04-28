package edu.iu.c322.menuservice.model;

public interface CustomerFactory {
    public Address createAddress();
    public CustomerInfo createCustomerInfo();
    public Payment createPayment();
}
