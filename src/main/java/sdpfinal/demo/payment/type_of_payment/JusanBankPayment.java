package sdpfinal.demo.payment.type_of_payment;

import sdpfinal.demo.payment.PaymentStrategy;

public class JusanBankPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Payment will be made to the Jusan Bank");
    }
}
