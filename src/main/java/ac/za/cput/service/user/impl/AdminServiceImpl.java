package ac.za.cput.service.user.impl;

import ac.za.cput.domain.user.Admin;
import ac.za.cput.repository.user.AdminRepository;
import ac.za.cput.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    private static AdminService adminService =null;

    @Autowired
    private AdminRepository adminRepository;

    private AdminServiceImpl(){

    }

    public static AdminService getCustomerService(){
        if(adminService ==null) adminService=new AdminServiceImpl();
        return adminService;
    }

    @Override
    public Admin retrieveByDesc(String customerDesc) {
        List<Admin> admins =getAll();
        for(Admin admin:admins)
        {
            if(admin.getEmail().equalsIgnoreCase(customerDesc))
                return admin;
        }
        return null;
    }

    @Override
    public List<Admin> getAll() {
        return this.adminRepository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public Admin read(String s) {
        Optional<Admin> optCustomer =this.adminRepository.findById(s);
        return optCustomer.orElse(null);
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(admin);
    }

    @Override
    public void delete(String s) {
        this.adminRepository.deleteById(s);

    }
}