# 💼 Employee Payroll Management System (JDBC + MySQL)

A console-based Java application that manages employee payroll using JDBC and MySQL.  
This project demonstrates real-time database interaction using SQL and Java.

---

## 🚀 Features

- Add Employee  
- Update Employee  
- Delete Employee  
- View Employees  
- View Employees with Department (JOIN)  
- Department Salary Report (GROUP BY)  
- Employees Above Average Salary (SUBQUERY)  
- Payroll Report (Tax, PF, Net Salary)  

---

## 🛠 Technologies Used

- Java  
- JDBC  
- MySQL  
- Maven  
- Object-Oriented Programming (OOP)  

---

## 📊 Key Concepts

- DAO Design Pattern  
- SQL JOIN  
- SQL GROUP BY  
- SQL Subqueries  
- Exception Handling  
- Try-with-resources  

---

## 📁 Project Structure

EmployeePayrollManagementSystem
│
├── src/main/java
│ ├── com.mysql.app
│ ├── com.mysql.dao
│ ├── com.mysql.entity
│ └── com.mysql.service
│
├── pom.xml
└── README.md
---

## ⚙️ Database Setup

```sql
CREATE DATABASE payroll_db;

Update DB connection in:

DBConnection.java

Example:

jdbc:mysql://localhost:3306/payroll_db

▶️ How to Run
Clone the repository
Open in Eclipse
Configure MySQL database
Run PayrollApp.java
📌 Project Highlights

✔ Clean layered architecture (DAO, Service, Entity)
✔ Real-time database operations
✔ Structured console UI
✔ Good coding practices

👨‍💻 Author

Vijay



---
