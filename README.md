# CSV Report Generator – Example Project 🎯📄 

This **Spring Boot** application is designed for managing **Customer** and **Loan** records with full CRUD operations. **Provides REST APIs to export loan data to CSV format using OpenCSV**. Built with Lombok, JPA, and MySQL for efficient data handling and reporting.

---

## What is CSV? 📘 

**CSV (Comma-Separated Values)** is a lightweight text format used to store tabular data.  
Each line is a row, and each value is separated by a comma (`,`).

---


---

##  Why We Use CSV in Projects? 🎯

- Export tabular data easily (e.g., loan reports)
- Openable in Excel, Google Sheets
- Easily shared between systems or teams
- Fast, lightweight, and simple to generate
- Used in dashboards, audits, and compliance

---

## How to Implement CSV Export in Spring Boot? ⚙️ 

### 🔹 Step-by-Step:

1. **Create Entities** – e.g., `Customer`, `Loan`
2. **Build Repositories** – Using Spring Data JPA
3. **Use OpenCSV** – Add OpenCSV dependency in `pom.xml`
4. **Create CSV Export Service** – Fetch data & write to CSV using `CSVWriter`
5. **Expose REST Endpoint** – Return file via `HttpServletResponse`

✔️ Use `Content-Disposition: attachment` header to trigger download.

---
