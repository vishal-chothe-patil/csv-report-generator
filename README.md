# CSV Report Generator – Project  ⚙️📄 

This **Spring Boot** application is designed for managing **Customer** and **Loan** records with full CRUD operations example. **Provides REST APIs to export loan data to CSV format using OpenCSV**. Built with Lombok, JPA, and MySQL for efficient data handling and reporting.

## What is CSV? 📘 

**CSV (Comma-Separated Values)** is a lightweight text format used to store tabular data.  
Each line is a row, and each value is separated by a comma (`,`).

---

##  Why We Use CSV in Projects?

- Export tabular data easily (e.g., loan reports)
- Openable in Excel, Google Sheets
- Easily shared between systems or teams
- Fast, lightweight, and simple to generate
- Used in dashboards, audits, and compliance

---

## How to Implement CSV Export in Spring Boot? 

### 🔹 Step-by-Step Guide

1. **Create Entities** – `Customer`, `Loan`
2. **Build Repositories** – `CustomerRepository`, `LoanRepository`
3. **Add OpenCSV Dependency** in `pom.xml`
4. **Create Service Layer** – Use `CSVWriter` to generate CSV
5. **Expose REST Endpoint** – Export CSV via `HttpServletResponse`

 Use `Content-Disposition: attachment` header to trigger download.

---

## Sample CSV Export Code (Service Layer)

This service method fetches all loans and exports them as a downloadable CSV:

  ```java
  @Service
  @RequiredArgsConstructor
  public class LoanReportService {
      private final LoanRepository loanRepository;
  
      public void generateCsvReport(HttpServletResponse response) throws Exception {
          List<Loan> loans = loanRepository.findAll();
  
          response.setContentType("text/csv");
          response.setHeader("Content-Disposition", "attachment; filename=loan_report.csv");
  
          PrintWriter writer = response.getWriter();
          CSVWriter csvWriter = new CSVWriter(writer);
          
          csvWriter.writeNext(new String[]{"Loan ID", "Customer Name", "Loan Type", "Amount", "Status", "Applied Date"});
  
          for (Loan loan : loans) {
              csvWriter.writeNext(new String[]{
                  loan.getId().toString(),
                  loan.getCustomer().getName(),
                  loan.getLoanType(),
                  String.valueOf(loan.getAmount()),
                  loan.getStatus(),
                  loan.getAppliedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
              });
          }
  
          csvWriter.close();
      }
  }
  ```

---
## Expose REST Endpoint (Controller)

  ```java
  
  @RestController
  @RequestMapping("/api/report")
  @RequiredArgsConstructor
  public class ReportController {
      private final ReportService reportService;
  
      @GetMapping("/loans")
      public void exportLoanCsv(HttpServletResponse response) throws Exception {
          reportService.generateCsvReport(response);
      }
  }
```

---

## Use in Postman

  -  Method: `GET`

  -  URL: `http://localhost:8080/api/report/loans`

  -  Response: CSV file `loan_report.csv` downloaded

---

## Summary

  - Easily generate CSV from loan data using CSVWriter.
  - Useful for export, compliance, and reporting features.
  -  Integrated with Spring Boot service-controller layers.
