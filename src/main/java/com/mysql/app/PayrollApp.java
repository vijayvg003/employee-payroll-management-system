package com.mysql.app;

import java.util.List;
import java.util.Scanner;

import com.mysql.dao.DepartmentDAO;
import com.mysql.dao.EmployeeDAO;
import com.mysql.entity.Department;
import com.mysql.entity.DepartmentSalary;
import com.mysql.entity.Employee;
import com.mysql.entity.EmployeeDept;
import com.mysql.service.PayrollService;

public class PayrollApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println();
			System.out.println("========================================");
		    System.out.println("1.Add Department");
		    System.out.println("2.Add Employee");
		    System.out.println("3.View Employee");
		    System.out.println("4.Update Employee");
		    System.out.println("5.Delete Employee");
		    System.out.println("6.View Employees With Department");
		    System.out.println("7.Department Salary Report");
		    System.out.println("8.View Employees Above Average Salary");
		    System.out.println("9.Payroll Report");
		    System.out.println("0.Exit");
		    System.out.println("-----------------------------------------");

		    System.out.print("Enter Your Choice: ");
		    System.out.println();
		    int choice = sc.nextInt();
			switch (choice) {
			//1. Add Department
			case 1:{
				sc.nextLine();
				System.out.println("Enter Dept Name: ");
				String depName = sc.nextLine();
				Department dept=new Department(depName);
				DepartmentDAO.addDepartment(dept);
				break;
			}
			//2. Add Employee
			case 2:{
				System.out.println("Enter Emp Name: ");
				sc.nextLine();
				String empName=sc.nextLine();
				System.out.println("Enter Emp Salary: ");
				double salary =sc.nextDouble();
				if(salary<0) {
					System.out.println("Invalid Salary! Salary cannot be Negative..");
				}
				
				System.out.println("Available Departments...");
				List<Department> dList = DepartmentDAO.viewDepartment();
				System.out.printf("%-10s %-15s\n","dept_id","dept name");
				System.out.println("-------------------------------------");
				for(Department d:dList) {
					System.out.printf("%-10d %-15s",d.getDepId(),d.getDepName());
					System.out.println();
				}
				System.out.println();
				System.out.println("Enter Dept Id: ");
				long deptId=sc.nextLong();
				Employee emp = new Employee(empName,salary,deptId);
				EmployeeDAO.addEmployee(emp);
				break;
			}
			//3. View Employees
			case 3:{
				System.out.println("Employee Details...");
				System.out.println();
				List<Employee> eList=EmployeeDAO.getAllEmployees();
				//used format statement to layout the table
				System.out.printf("%-10s %-10s %-10s %-10s\n","emp_id","emp_name","emp_salary","dept_id");
				System.out.println("------------------------------------------");
				
				for(Employee e:eList ) {
					System.out.printf("%-10d %-10s %-10.2f %-10d\n",e.getEmpId(),e.getEmpName(),e.getSalary(),e.getDeptId());
				}
				System.out.println();
				break;
			}
			//4. Update Employee
			case 4:{
				System.out.println("Enter the Employee Id: ");
				long empId =sc.nextLong();
				System.out.println("Enter New Salary: ");
				double newSalary =sc.nextDouble();
				if(newSalary<0) {
					System.out.println("Invalid Salary");
				}
				System.out.println("Enter New Department Id: ");
				long newDeptId=sc.nextLong();
				Employee emp = new Employee(empId, newSalary,newDeptId);
				EmployeeDAO.updateEmployee(emp);
				break;
			}
			//5. Delete Employee
			case 5:{
				System.out.println("Enter Employee Id: ");
				long empId =sc.nextLong();
				Employee emp = new Employee(empId);
				EmployeeDAO.deleteEmployee(emp);
				break;
			}
//			6.View Employees With Department
			case 6: {
			    System.out.println("Employees With Department...");
			    System.out.println();

			    List<EmployeeDept> list = EmployeeDAO.getEmployeesWithDepartment();

			    System.out.printf("%-7s %-13s %-10s %-10s %-12s\n",
			            "emp_id", "emp_name", "salary", "dept_id", "dept_name");

			    System.out.println("----------------------------------------------------");

			    for (EmployeeDept e : list) {
			        System.out.printf("%-7d %-13s %-10.2f %-10d %-12s\n",
			                e.getEmpId(),
			                e.getEmpName(),
			                e.getSalary(),
			                e.getDeptId(),
			                e.getDeptName());
			    }

			    System.out.println();
			    break;
			}
			
//			7.Department Salary Report
			case 7: {
			    System.out.println("Department Salary Report\n");

			    List<DepartmentSalary> list = EmployeeDAO.getDepartmentSalaryReport();

			    System.out.printf("%-8s %-15s %-15s\n", "Dep_Id", "Dept_Name", "Total_Salary");
			    System.out.println("-------------------------------------");

			    for (DepartmentSalary d : list) {
			        System.out.printf("%-8s %-15s %-15.2f\n",
			                d.getDeptId(),
			        		d.getDeptName(),
			                d.getTotalSalary());
			    }

			    break;
			}
			
//			8.View Employees Above Average Salary  
			case 8: {
			    System.out.println("Employees Above Average Salary\n");

			    List<Employee> list = EmployeeDAO.getEmployeesAboveAverageSalary();

			    if (list.isEmpty()) {
			        System.out.println("No employees found above average salary.\n");
			        break;
			    }
			    System.out.printf("%-8s %-13s %-10s %-10s\n",
			            "emp_id", "emp_name", "salary", "dept_id");

			    System.out.println("-----------------------------------------");
			    
			    for (Employee e : list) {
			        System.out.printf("%-8d %-13s %-10.2f %-10d\n",
			                e.getEmpId(),
			                e.getEmpName(),
			                e.getSalary(),
			                e.getDeptId());
			    }

			    System.out.println();
			    break;
			}
			
			//9. Payroll Report
			case 9:{
				List<Employee> list = EmployeeDAO.getAllEmployees();
				PayrollService service = new PayrollService();
				service.getPayrollReport(list);
				break;
			}
//			Exit
			case 0:{
				System.out.println();
				System.out.println("Thank You Visit Again!!!");
				System.out.println("----*----*----*----*----*----*----*----");
				flag=false;
				break;
			}
//			Invalid
			default:
				System.out.println();
				System.out.println("**** Invalid Option ****");
				break;
			}
		}
		sc.close();
	}
}


