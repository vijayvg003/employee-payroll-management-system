//	Entity Class
package com.mysql.entity;

public class Employee {
	
	private long empId;
	private String empName;
	private double salary;
	private long deptId;
	
//	Empty Object Creation
	public Employee() {
		
	}
	
//	Find Employee from Database
	public Employee(long empId, String empName, double salary, long deptId) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.deptId = deptId;
	}
	
//	Insert Employee
	public Employee(String empName, double salary, long deptId) {
		this.empName = empName;
		this.salary = salary;
		this.deptId = deptId;
	}
	

	//Update employee
	public Employee(long empId, double salary, long deptId) {
		this.empId = empId;
		this.salary = salary;
		this.deptId = deptId;
		
	}
	
//	Delete Employee
	public Employee(long empId2) {
		this.empId = empId2;
	}
	
	
	public long getEmpId() {
		return empId;
	}
	
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public long getDeptId() {
		return deptId;
	}
	
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", deptId=" + deptId + "]";
	}
	
	
}
