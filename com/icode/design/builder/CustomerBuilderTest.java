package com.icode.design.builder;

public class CustomerBuilderTest {

    public static void main(String[] args) {

        Customer customer = new Customer.CustomerBuilder(1, "Santosh")
                .address("Bangalore")
                .citizen("Indian")
                .build();

        System.out.println(customer);
    }
}
