package com.mysql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.entity.Department;

public class DepartmentDAO {
//	Add Department
	public static void addDepartment(Department dept) {
		try {
			Connection con = DBConnection.getConnection();
			String query = "insert into department(dept_name) values(?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, dept.getDepName());
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("Department added Successfully");
			}
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	View Department
	public static List<Department> viewDepartment() {
		List<Department> dList=new ArrayList<Department>();
		try {
			Connection con = DBConnection.getConnection();
			String query = "select * from department";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Department dept=new Department(
						rs.getLong("dept_id"),
						rs.getString("dept_name")
				);
				dList.add(dept);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dList;
		
	}
}
