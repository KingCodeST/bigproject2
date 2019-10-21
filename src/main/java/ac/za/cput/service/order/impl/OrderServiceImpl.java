package ac.za.cput.service.order.impl;

import ac.za.cput.domain.order.Orders;
import ac.za.cput.repository.order.OrderRepository;
import ac.za.cput.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    private static OrderService orderService =null;

    @Autowired
    private OrderRepository orderRepository;

    private OrderServiceImpl(){

    }

    public static OrderService getCustomerService(){
        if(orderService ==null) orderService=new OrderServiceImpl();
        return orderService;
    }

    @Override
    public Orders retrieveByDesc(String customerDesc) {
        List<Orders> customers =getAll();
        for(Orders customer:customers)
        {
            if(customer.getOrderId().equalsIgnoreCase(customerDesc))
                return customer;
        }
        return null;
    }

    @Override
    public List<Orders> getAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Orders create(Orders customer) {
        return this.orderRepository.save(customer);
    }

    @Override
    public Orders read(String s) {
        Optional<Orders> optCustomer =this.orderRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Orders update(Orders customer) {
        return this.orderRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.orderRepository.deleteById(s);

    }
}