package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.Race;
import ac.za.cput.repository.user.RaceRepository;
import ac.za.cput.service.user.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService {

    private static RaceService raceService =null;

    @Autowired
    private RaceRepository raceRepository;

    private RaceServiceImpl(){

    }

    public static RaceService getCustomerService(){
        if(raceService ==null) raceService=new RaceServiceImpl();
        return raceService;
    }

    @Override
    public Race retrieveByDesc(String customerDesc) {
        List<Race> customers =getAll();
        for(Race customer:customers)
        {
            if(customer.getDesc().equalsIgnoreCase(customerDesc))
                return customer;
        }
        return null;
    }

    @Override
    public List<Race> getAll() {
        return this.raceRepository.findAll();
    }

    @Override
    public Race create(Race customer) {
        return this.raceRepository.save(customer);
    }

    @Override
    public Race read(String s) {
        Optional<Race> optCustomer =this.raceRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Race update(Race customer) {
        return this.raceRepository.save(customer);
    }

    @Override
    public void delete(String s) {
        this.raceRepository.deleteById(s);

    }
}