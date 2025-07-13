package com.expertise.csv.report.generator.example.service;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportServiceI {

    void exportLoanReport(HttpServletResponse response);

}
