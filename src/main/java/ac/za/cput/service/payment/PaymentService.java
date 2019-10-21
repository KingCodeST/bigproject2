package ac.za.cput.service.payment;

import ac.za.cput.domain.payment.Payment;
import ac.za.cput.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService extends IService<Payment,String> {
    Payment retrieveByDesc(String paymentDesc);
    List<Payment> getAll();

}
