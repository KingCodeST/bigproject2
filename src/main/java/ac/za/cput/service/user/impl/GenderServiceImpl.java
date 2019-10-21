package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.Gender;
import ac.za.cput.repository.user.GenderRepository;
import ac.za.cput.service.user.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {


    private static GenderService genderService =null;

    @Autowired
    private GenderRepository genderRepository;

    private GenderServiceImpl(){

    }

    public static GenderService getCustomerService(){
        if(genderService ==null) genderService=new GenderServiceImpl();
        return genderService;
    }

    @Override
    public Gender retrieveByDesc(String customerDesc) {
        List<Gender> customers =getAll();
        for(Gender customer:customers)
        {
            if(customer.getDesc().equalsIgnoreCase(customerDesc))
                return customer;
        }
        return null;
    }

    @Override
    public List<Gender> getAll() {
        return this.genderRepository.findAll();
    }

    @Override
    public Gender create(Gender customer) {
        return this.genderRepository.save(customer);
    }

    @Override
    public Gender read(String s) {
        Optional<Gender> optCustomer =this.genderRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Gender update(Gender customer) {
        return this.genderRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.genderRepository.deleteById(s);

    }
}