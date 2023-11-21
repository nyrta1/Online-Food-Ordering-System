package sdpfinal.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sdpfinal.demo.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
