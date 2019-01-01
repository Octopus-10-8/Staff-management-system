package com.octopus.service;

import java.util.List;

import com.octopus.entity.Employee;

/**
 *   员工管理的业务逻辑接口
 * @author Administrator
 *
 */
public interface EmployeeService {

	
	public List<Employee> list(Employee emp);
	
	
	
	/**
	 *  添加员工信息
	 * @param emp
	 * @return
	 */
	
	public boolean add(Employee emp);
	
	
	/** 信息修改
	 *  根据编号查询员工信息
	 *   得到单个员工信息
	 *  
	 */
	
	public Employee getEmployee(Employee emp);
	
	/**
	 *  修改员工信息，更新操作
	 * @param emp
	 * @return
	 */
	public boolean update(Employee emp);
	
	
	/**
	 *  删除员工信息
	 */
	
	
	public boolean delete(Employee emp);
	
	
	
	/**
	 *  查询用户信息 登陆验证
	 *   
	 */
	
	public Employee isLogin(Employee emp);
	
	
}
