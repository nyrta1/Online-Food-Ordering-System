package sdpfinal.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdpfinal.demo.models.Customer;
import sdpfinal.demo.models.Restaurant;
import sdpfinal.demo.repositories.UserRepository;
import sdpfinal.demo.services.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(Customer customer) {
        userRepository.save(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
