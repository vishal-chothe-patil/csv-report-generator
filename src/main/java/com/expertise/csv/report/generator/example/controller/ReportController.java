package com.expertise.csv.report.generator.example.controller;

import com.expertise.csv.report.generator.example.service.CustomerServiceI;
import com.expertise.csv.report.generator.example.service.LoanServiceI;
import com.expertise.csv.report.generator.example.service.ReportServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private CustomerServiceI customerServiceI;

    @Autowired
    private LoanServiceI loanServiceI;

    @Autowired
    private ReportServiceI reportServiceI;

}
