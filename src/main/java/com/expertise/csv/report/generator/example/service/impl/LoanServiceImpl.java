package com.expertise.csv.report.generator.example.service.impl;

import com.expertise.csv.report.generator.example.model.Customer;
import com.expertise.csv.report.generator.example.model.Loan;
import com.expertise.csv.report.generator.example.repository.CustomerRepository;
import com.expertise.csv.report.generator.example.repository.LoanRepository;
import com.expertise.csv.report.generator.example.service.LoanServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanServiceI {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Loan addLoan(Loan loan) {
        Customer customer = customerRepository.findById(loan.getCustomer().getId())
                .orElseThrow();
        loan.setCustomer(customer);
        return loanRepository.save(loan);
    }
}
