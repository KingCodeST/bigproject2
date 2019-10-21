package ac.za.cput.service.order.impl;

import ac.za.cput.domain.order.OrderDetail;
import ac.za.cput.repository.order.OrderDetailRepository;
import ac.za.cput.service.order.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {


    private static OrderDetailService orderDetailService =null;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    private OrderDetailServiceImpl(){

    }

    public static OrderDetailService getCustomerService(){
        if(orderDetailService ==null) orderDetailService=new OrderDetailServiceImpl();
        return orderDetailService;
    }

    @Override
    public OrderDetail retrieveByDesc(String customerDesc) {
        List<OrderDetail> customers =getAll();
        for(OrderDetail customer:customers)
        {
            if(customer.getTaxStatus().equalsIgnoreCase(customerDesc))
                return customer;
        }
        return null;
    }

    @Override
    public List<OrderDetail> getAll() {
        return this.orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail create(OrderDetail customer) {
        return this.orderDetailRepository.save(customer);
    }

    @Override
    public OrderDetail read(String s) {
        Optional<OrderDetail> optCustomer =this.orderDetailRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public OrderDetail update(OrderDetail customer) {
        return this.orderDetailRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.orderDetailRepository.deleteById(s);

    }
}