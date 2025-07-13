package com.expertise.csv.report.generator.example.repository;

import com.expertise.csv.report.generator.example.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
