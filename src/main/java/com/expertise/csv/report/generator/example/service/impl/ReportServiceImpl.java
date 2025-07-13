package com.expertise.csv.report.generator.example.service.impl;

import com.expertise.csv.report.generator.example.service.ReportServiceI;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportServiceI {

    @Override
    public void exportLoanReport(HttpServletResponse response) {

    }
}
