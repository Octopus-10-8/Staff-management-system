package com.octopus.entity;

import java.util.Date;


/**
 *   员工管理的实体类
 * @author Administrator
 *
 */
public class Employee {

	private Integer employeeId;
	
	private Integer departmentId;
	
	private String  employeeName;
	
	private String  employeeSex;
	
	private Integer employeeAge;
	
	private String employeePhone;
	
	private Date employeeTIme;
	
	private String userId;
	
	private String userPw;
	
	//部门名称
	private String departmentName;
	
	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSex() {
		return employeeSex;
	}

	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}

	public Integer getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(Integer employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public Date getEmployeeTIme() {
		return employeeTIme;
	}

	public void setEmployeeTIme(Date employeeTIme) {
		this.employeeTIme = employeeTIme;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", departmentId="
				+ departmentId + ", employeeName=" + employeeName
				+ ", employeeSex=" + employeeSex + ", employeeAge="
				+ employeeAge + ", employeePhone=" + employeePhone
				+ ", employeeTIme=" + employeeTIme + ", userId=" + userId
				+ ", userPw=" + userPw + ", departmentName=" + departmentName
				+ "]";
	}
	
	
}
