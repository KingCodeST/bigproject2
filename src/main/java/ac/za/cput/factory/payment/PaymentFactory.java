package ac.za.cput.factory.payment;

import ac.za.cput.domain.payment.Payment;
import ac.za.cput.util.Misc;

public class PaymentFactory {

    public static Payment GenerateBuilder(float money)
    {
        return new Payment.Builder()
                          .setAmount(money)
                          .setPaymentId(Misc.generatedId())
                          .build();
    }


}
