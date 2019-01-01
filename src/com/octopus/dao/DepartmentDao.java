package com.octopus.dao;

import java.util.List;

import com.octopus.entity.Department;

public interface DepartmentDao {

	
	 /*
	  *   查询部门信息
	  */
	public List<Department> list(String sql,Object[] arr)throws Exception;
	
	 
	//根据编号ID查询单条信息
	public Department getDepartment(Department de)throws Exception; 
		
	
}
