package sdpfinal.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sdpfinal.demo.models.Customer;

public interface UserRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
}
