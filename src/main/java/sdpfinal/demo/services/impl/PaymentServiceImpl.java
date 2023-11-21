package sdpfinal.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdpfinal.demo.models.Payment;
import sdpfinal.demo.repositories.PaymentRepository;
import sdpfinal.demo.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }
}
