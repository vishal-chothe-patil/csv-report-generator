package com.expertise.csv.report.generator.example.controller;

import com.expertise.csv.report.generator.example.model.Customer;
import com.expertise.csv.report.generator.example.model.Loan;
import com.expertise.csv.report.generator.example.service.CustomerServiceI;
import com.expertise.csv.report.generator.example.service.LoanServiceI;
import com.expertise.csv.report.generator.example.service.ReportServiceI;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/csv")
public class ReportController {

    @Autowired
    private CustomerServiceI customerServiceI;

    @Autowired
    private LoanServiceI loanServiceI;

    @Autowired
    private ReportServiceI reportServiceI;

    @PostMapping("/customers") // Add customer
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerServiceI.addCustomer(customer);
    }

    @PostMapping("/loans") // Add loan with customer ID
    public Loan addLoan(@RequestBody Loan loan) {
        return loanServiceI.addLoan(loan);
    }

    @GetMapping("/report")
    public void exportCsv(HttpServletResponse response) {
        try {
            reportServiceI.exportLoanReport(response);
        } catch (Exception e) {
            log.error("Error occurred while exporting CSV report", e);
        }
    }

}
