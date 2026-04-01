package com.CMS.reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CMS.entity.Customer;

public interface CustumerRepo extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username); // important
}