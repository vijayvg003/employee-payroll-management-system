//	Entity Class
package com.mysql.entity;

public class Department {
	private long depId;
	private String depName;
	
//	Empty Object Creation
	public Department() {
		
	}
	
//	Insert Department
	public Department(String depName) {
		this.depName = depName;
	}

	
//	Fetch Employee from Database
	public Department(long depId, String depName) {
		this.depId = depId;
		this.depName = depName;
	}
	
	public long getDepId() {
		return depId;
	}

	public void setDepId(long depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}
	
	
	
	
	
}
