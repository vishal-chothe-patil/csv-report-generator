package com.expertise.csv.report.generator.example.service.impl;

import com.expertise.csv.report.generator.example.repository.CustomerRepository;
import com.expertise.csv.report.generator.example.service.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

    @Autowired
    private CustomerRepository customerRepository;
}
