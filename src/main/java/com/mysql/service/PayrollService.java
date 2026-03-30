package com.mysql.service;

import java.util.List;
import com.mysql.entity.Employee;

public class PayrollService {
    public void getPayrollReport(List<Employee> employees) {
    	
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-7s %-10s %-10s %-10s %-10s %-12s\n",
                "EmpId", "Name", "Salary", "Tax(10%)", "PF(5%)", "NetSalary");
        System.out.println("-------------------------------------------------------------");
        
        for (Employee e : employees) {
            long id = e.getEmpId();
            String name = e.getEmpName();
            double salary = e.getSalary();
            double tax = salary * 0.10;
            double pf = salary * 0.05;
            double netSalary = salary - tax - pf;
            System.out.printf("%-7d %-10s %-10.2f %-10.2f %-10.2f %-12.2f\n",
                    id, name, salary, tax, pf, netSalary);
        }
    }
}