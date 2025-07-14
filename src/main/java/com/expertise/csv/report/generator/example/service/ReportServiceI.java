package com.expertise.csv.report.generator.example.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ReportServiceI {

    void exportLoanReport(HttpServletResponse response) throws IOException;

}
