package com.octopus.dao;

import java.util.List;

import com.octopus.entity.Employee;

/**
 * 员工管理的数据访问层
 * 
 * @author Administrator
 *
 */

public interface EmployeeDao {
   
	/**
	 *  根据条件查询员工信息
	 * @param sql
	 * @param arr
	 * @return
	 * @throws Exception
	 */
	public List<Employee> list(String sql,Object[] arr) throws Exception;

	
	/**
	 *  根据编号查询员工信息，单条数据
	 * @param emp
	 * @return
	 * @throws Exception
	 */
	public Employee getEmployee(Employee emp)throws Exception;
	 
	
	
	/**
	 *   验证登录用户
	 */
	
	public Employee isLogin(Employee emp)throws Exception;
	
}
