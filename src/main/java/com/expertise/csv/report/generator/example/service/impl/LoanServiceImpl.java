package com.expertise.csv.report.generator.example.service.impl;

import com.expertise.csv.report.generator.example.repository.LoanRepository;
import com.expertise.csv.report.generator.example.service.LoanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanServiceI {

    @Autowired
    private LoanRepository loanRepository;
}
