package com.mysql.entity;

public class DepartmentSalary {
	private long deptId;
    private String deptName;
    private double totalSalary;

    public DepartmentSalary(long deptId, String deptName, double totalSalary) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.totalSalary = totalSalary;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
    
    public String getDeptName() {
        return deptName;
    }

	public double getTotalSalary() {
        return totalSalary;
    }
}
