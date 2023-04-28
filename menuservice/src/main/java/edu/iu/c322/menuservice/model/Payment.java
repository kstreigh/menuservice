package edu.iu.c322.menuservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Payment method cannot be empty.")
    @Column(name = "method")
    private String method;

    @NotEmpty(message = "Credit card number cannot be empty.")
    @Column(name = "number")
    private String number;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address billingAddress;

    public Payment() {
    }
}
