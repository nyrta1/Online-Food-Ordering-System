package sdpfinal.demo.factory;

import sdpfinal.demo.models.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String firstName,
                                   String lastName,
                                   String username,
                                   String phone,
                                   String address,
                                   String password,
                                   String role) {
        Customer customer = new Customer();
        customer.setCustomerId(null);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setUsername(username);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setPassword(password);
        customer.setRole(role);

        return customer;
    }
}
