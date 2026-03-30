package com.mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.entity.DepartmentSalary;
import com.mysql.entity.Employee;
import com.mysql.entity.EmployeeDept;


public class EmployeeDAO {
	//	2.Add employee
	public static void addEmployee(Employee emp) {
		String query = "insert into employee(emp_name,salary,dept_id) values(?,?,?)";
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			){			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setDouble(2, emp.getSalary());
			pstmt.setLong(3, emp.getDeptId());
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Employee was Added...");
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	3.View employee(List)
	public static List<Employee> getAllEmployees() {
		List<Employee> list=new ArrayList<Employee>();
		String query = "select * from employee";
		try (
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
			
			while(rs.next()) {
				Employee emp=new Employee(
						rs.getLong("emp_id"),
						rs.getString("emp_name"),
						rs.getDouble("salary"),
						rs.getLong("dept_id")
				);
				list.add(emp);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	4.Update employee
	public static void updateEmployee(Employee emp ) {
		String query = "update employee set salary=?,dept_id=? where emp_id=?";
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);){
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setLong(2, emp.getDeptId());
			pstmt.setLong(3, emp.getEmpId());
			int row = pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println("Employee Updated Successfully...");
			}
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	5.Delete employee
	public static void deleteEmployee(Employee emp) {
		String query = "delete from employee where emp_id=?";
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			){
			pstmt.setLong(1, emp.getEmpId());
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Employee was Deleted!!!");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	6.View employees with department (JOINS)
	public static List<EmployeeDept> getEmployeesWithDepartment() {
		
		List<EmployeeDept> list = new ArrayList<>();
		String query = "select emp.emp_id, emp.emp_name, emp.salary, dept.dept_id, dept.dept_name "
                + "from employee emp, department dept "
                + "where emp.dept_id = dept.dept_id";
	    try (Connection con = DBConnection.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(query);){
	    	
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            EmployeeDept ed = new EmployeeDept(
	                rs.getLong("emp_id"),
	                rs.getString("emp_name"),
	                rs.getDouble("salary"),
	                rs.getLong("dept_id"),
	                rs.getString("dept_name")
	            );
	            list.add(ed);
	        }
	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
//	7.Calculate department salary total (GROUP BY)
	public static List<DepartmentSalary> getDepartmentSalaryReport() {

	    List<DepartmentSalary> list = new ArrayList<>();
	    String query = "SELECT dept.dept_id ,dept.dept_name, SUM(emp.salary) AS total_salary "
                + "FROM employee emp inner join department dept "
                + "ON emp.dept_id = dept.dept_id "
                + "GROUP BY dept.dept_id,dept.dept_name "
                + "LIMIT 20";
	    try (Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();){
	        
	        while (rs.next()) {
	            DepartmentSalary ds = new DepartmentSalary(
	            		rs.getLong("dept_id"),
	                rs.getString("dept_name"),
	                rs.getDouble("total_salary")
	            );
	            list.add(ds);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	// 8. View employees above average salary (SUBQUERY)
	public static List<Employee> getEmployeesAboveAverageSalary() {

	    List<Employee> list = new ArrayList<>();

	    String query = "SELECT emp_id, emp_name, salary, dept_id "
	                 + "FROM employee "
	                 + "WHERE salary >= (SELECT AVG(salary) FROM employee)";  // ✅ changed > to >=

	    try (
	        Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	    ) {

	        while (rs.next()) {

	            Employee emp = new Employee(
	                rs.getLong("emp_id"),
	                rs.getString("emp_name"),
	                rs.getDouble("salary"),
	                rs.getLong("dept_id")
	            );

	            list.add(emp);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}