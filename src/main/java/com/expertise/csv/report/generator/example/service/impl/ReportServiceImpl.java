package com.expertise.csv.report.generator.example.service.impl;

import com.expertise.csv.report.generator.example.model.Loan;
import com.expertise.csv.report.generator.example.repository.LoanRepository;
import com.expertise.csv.report.generator.example.service.ReportServiceI;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportServiceI {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void exportLoanReport(HttpServletResponse response) throws IOException {
        List<Loan> loans = loanRepository.findAll();

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=loan_report.csv");

        CSVWriter writer = new CSVWriter(response.getWriter());
        writer.writeNext(new String[]{"Loan ID", "Customer", "Type", "Amount", "Status", "Date"});

        for (Loan loan : loans) {
            writer.writeNext(new String[]{loan.getId().toString(), loan.getCustomer().getName(), loan.getLoanType(), String.valueOf(loan.getAmount()), loan.getStatus(), loan.getAppliedDate().toString()});
        }

        writer.close();
    }
}
