package com.expertise.csv.report.generator.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanType;
    private Double amount;
    private String status;
    private LocalDate appliedDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
