package com.mysql.entity;

public class EmployeeDept {

    private long empId;
    private String empName;
    private double salary;
    private long deptId;
    private String deptName;

    
    public EmployeeDept(long empId, String empName, double salary, long deptId, String deptName) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    
    public long getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public long getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
}