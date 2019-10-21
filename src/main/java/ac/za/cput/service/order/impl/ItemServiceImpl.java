package ac.za.cput.service.order.impl;

import ac.za.cput.domain.order.Item;
import ac.za.cput.repository.order.ItemRepository;
import ac.za.cput.service.order.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private static ItemService customerService =null;

    @Autowired
    private ItemRepository rtemRepository;

    private ItemServiceImpl(){

    }

    public static ItemService getCustomerService(){
        if(customerService ==null) customerService=new ItemServiceImpl();
        return customerService;
    }

    @Override
    public Item retrieveByDesc(String customerDesc) {
        List<Item> customers =getAll();
        for(Item customer:customers)
        {
            if(customer.getDescription().equalsIgnoreCase(customerDesc))
                return customer;
        }
        return null;
    }

    @Override
    public List<Item> getAll() {
        return this.rtemRepository.findAll();
    }

    @Override
    public Item create(Item customer) {
        return this.rtemRepository.save(customer);
    }

    @Override
    public Item read(String s) {
        Optional<Item> optCustomer =this.rtemRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Item update(Item customer) {
        return this.rtemRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.rtemRepository.deleteById(s);

    }
}