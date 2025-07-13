package com.expertise.csv.report.generator.example.controller;

import com.expertise.csv.report.generator.example.model.Customer;
import com.expertise.csv.report.generator.example.model.Loan;
import com.expertise.csv.report.generator.example.service.CustomerServiceI;
import com.expertise.csv.report.generator.example.service.LoanServiceI;
import com.expertise.csv.report.generator.example.service.ReportServiceI;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("/report/loans")
    public ResponseEntity<String> exportCsv(HttpServletResponse response) {
        try {
            reportServiceI.exportLoanReport(response);
            return ResponseEntity.ok("Report exported successfully as CSV.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to export report: " + e.getMessage());
        }
    }

}
