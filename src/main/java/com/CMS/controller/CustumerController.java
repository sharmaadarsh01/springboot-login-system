package com.CMS.controller;

import org.springframework.web.bind.annotation.*;

import com.CMS.entity.Customer;
import com.CMS.service.CustumerService;

@RestController
@CrossOrigin(origins = "*") // frontend connect ke liye
public class CustumerController {

    private CustumerService cService;

    public CustumerController(CustumerService cService) {
        this.cService = cService;
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer cus) {

        if (cService.validate(cus))
            return "Login Success!";
        else
            return "Login Failed!";
    }

    @PostMapping("/register")
    public String register(@RequestBody Customer cus) {
        return cService.addUser(cus);
    }
    
    @GetMapping("/")
    public String home() {
        return "Server Running!";
    }
}