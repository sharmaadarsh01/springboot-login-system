package com.CMS.service;

import org.springframework.stereotype.Service;
import com.CMS.entity.Customer;
import com.CMS.reprository.CustumerRepo;

@Service
public class CustomerServiceImplementation implements CustumerService {

    private CustumerRepo cusRepo;

    public CustomerServiceImplementation(CustumerRepo cusRepo) {
        this.cusRepo = cusRepo;
    }

    @Override
    public boolean validate(Customer cus) {

        Customer dbUser = cusRepo.findByUsername(cus.getUsername());

        if (dbUser == null) {
            return false;
        }

        return cus.getPassword().equals(dbUser.getPassword());
    }

    @Override
    public String addUser(Customer cus) {

        Customer existingUser = cusRepo.findByUsername(cus.getUsername());

        if (existingUser != null) {
            return "Username already exists!";
        } else {
            cusRepo.save(cus);
            return "User Registered Successfully!";		
        }
    }
}






