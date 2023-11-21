package sdpfinal.demo.payment.type_of_payment;

import sdpfinal.demo.payment.PaymentStrategy;

public class KaspiBankPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be made to the Kaspi Bank");
    }
}
