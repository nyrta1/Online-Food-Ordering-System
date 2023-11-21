package sdpfinal.demo.payment.type_of_payment;

import sdpfinal.demo.models.Payment;
import sdpfinal.demo.payment.PaymentStrategy;

public class HalykBankPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be made to the Halyk Bank");
    }
}
