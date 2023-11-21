package sdpfinal.demo.services;

import sdpfinal.demo.models.Customer;
import sdpfinal.demo.models.Restaurant;

import java.util.List;

public interface UserService {
    void save(Customer customer);
    Customer findByUsername(String username);
}
