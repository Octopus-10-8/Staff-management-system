package com.octopus.service;

import java.util.List;

import com.octopus.entity.Department;

public interface DepartmentService {

	 /**
	  * 根据条件查询部门信息
	  * @param de  查询条件
	  * @return   返回多个部门信息
	  */
	
	public List<Department> list(Department de);
	
	
	
	
	
	
	/**
	 *  添加部门信息
	 */
	public boolean add(Department de);
	
	
	
	/**
	 *   根据ID值显示部门单条信息
	 */
	
	
	public Department getDepartment(Department de);
	
	
	
	/**
	 *   修改部门信息
	 *   
	 */
	
	public boolean update(Department de);
	
	
	
	/**
	 * 删除部门信息
	 */
	public boolean delete(Department de);
}
