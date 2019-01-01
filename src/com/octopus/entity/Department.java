package com.octopus.entity;

/**
 * 部门实体类
 * 
 * @author Administrator
 *
 */
public class Department {

	private Integer departmentId;
	private String departmentName;
	private String departmentDesc;
	private String departmentMark;   //标识，假删除
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDesc() {
		return departmentDesc;
	}
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}
	public String getDepartmentMark() {
		return departmentMark;
	}
	public void setDepartmentMark(String departmentMark) {
		this.departmentMark = departmentMark;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentDesc="
				+ departmentDesc + ", departmentMark=" + departmentMark + "]";
	}
	public Department(Integer departmentId, String departmentName, String departmentDesc, String departmentMark) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
		this.departmentMark = departmentMark;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
