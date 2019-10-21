package ac.za.cput.service.order.impl;

import ac.za.cput.domain.order.OrderStatus;
import ac.za.cput.repository.order.OrderStatusRepository;
import ac.za.cput.service.order.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {


    private static OrderStatusService orderStatusService =null;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    private OrderStatusServiceImpl(){

    }

    public static OrderStatusService getCustomerService(){
        if(orderStatusService ==null) orderStatusService=new OrderStatusServiceImpl();
        return orderStatusService;
    }

    @Override
    public OrderStatus retrieveByDesc(String customerDesc) {
        List<OrderStatus> orderStatus =getAll();
        for(OrderStatus orderStatu:orderStatus)
        {
            if(orderStatu.getOstatusId().equalsIgnoreCase(customerDesc))
                return orderStatu;
        }
        return null;
    }

    @Override
    public List<OrderStatus> getAll() {
        return this.orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus create(OrderStatus orderStatu) {
        return this.orderStatusRepository.save(orderStatu);
    }

    @Override
    public OrderStatus read(String s) {
        Optional<OrderStatus> optCustomer =this.orderStatusRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public OrderStatus update(OrderStatus orderStatu) {
        return this.orderStatusRepository.save(orderStatu);
    }

    @Override
    public void delete(String s) {
        this.orderStatusRepository.deleteById(s);

    }
}