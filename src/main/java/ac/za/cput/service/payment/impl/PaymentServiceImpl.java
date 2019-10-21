package ac.za.cput.service.payment.impl;

import ac.za.cput.domain.payment.Payment;
import ac.za.cput.repository.payment.PaymentRepository;
import ac.za.cput.service.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {


    private static PaymentService paymentService =null;

    @Autowired
    private PaymentRepository paymentRepository;

    private PaymentServiceImpl(){

    }

    public static PaymentService getCustomerService(){
        if(paymentService ==null) paymentService=new PaymentServiceImpl();
        return paymentService;
    }

    @Override
    public Payment retrieveByDesc(String customerDesc) {
        List<Payment> payments =getAll();
        for(Payment payment:payments)
        {
            if(payment.getPymentId().equalsIgnoreCase(customerDesc))
                return payment;
        }
        return null;
    }

    @Override
    public List<Payment> getAll() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment create(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public Payment read(String s) {
        Optional<Payment> optCustomer =this.paymentRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    @Override
    public void delete(String s) {
        this.paymentRepository.deleteById(s);

    }
}