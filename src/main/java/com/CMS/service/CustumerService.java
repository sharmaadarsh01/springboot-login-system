package com.CMS.service;

import com.CMS.entity.Customer;

public interface CustumerService {

    boolean validate(Customer cus);
    String addUser(Customer cus);
}