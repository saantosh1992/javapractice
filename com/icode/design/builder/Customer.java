package com.icode.design.builder;

public class Customer {

    private int id;
    private String name;
    private String address;
    private String citizen;

    private Customer(CustomerBuilder cb) {
        this.id = cb.id;
        this.name = cb.name;
        this.address = cb.address;
        this.citizen = cb.citizen;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCitizen() {
        return citizen;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", citizen='" + citizen + '\'' +
                '}';
    }

    static class CustomerBuilder {
        private int id;
        private String name;
        private String address;
        private String citizen;

        public CustomerBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public CustomerBuilder citizen(String citizen) {
            this.citizen = citizen;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }
}
