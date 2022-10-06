package com.company;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setFirstName("Sydney");
        customer.setLastName("Mercier");
        customer.setEmail("sydney.mercier91@gmail.com");
        customer.setPhone("888-888-8888");

        Address address = new Address();
        address.setStreet1("748 Home St");
        address.setCity("Hometown");
        address.setState("Texas");
        address.setZip("77777");

        customer.setShippingAddress(address);
        customer.setBillingAddress(address);
        customer.setRewardsMember(true);

        System.out.println(customer);
    }
}