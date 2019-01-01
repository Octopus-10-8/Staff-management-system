package com.octopus.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.octopus.dao.EmployeeDao;
import com.octopus.entity.Employee;
import com.octopus.utils.DButils;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> list(String sql, Object[] arr) throws Exception {

		QueryRunner qr = DButils.getQueryRunner();

		return qr.query(sql, new BeanListHandler<Employee>(Employee.class), arr);
	}

	public Employee getEmployee(Employee emp) throws Exception {
		QueryRunner qr = DButils.getQueryRunner();
		// 查询员工表所有列和部门表部门名称列
		String sql = "SELECT e.*, d.departmentName from employee e,department d where e.departmentId=d.departmentId and e.employeeId=?";
		return qr.query(sql, new BeanHandler<Employee>(Employee.class), emp.getEmployeeId());
	}

	/**
	 * 验证用户登陆
	 */
	@Override
	public Employee isLogin(Employee emp) throws Exception {

		String sql = "SELECT e.*, d.departmentName from employee e,department d where e.departmentId=d.departmentId and e.userId=? and e.userPw=?";

		QueryRunner qr = DButils.getQueryRunner();
		
		//这里处理的是俩个单个信息，不是数组，可以使用BeanHandler处理
		return qr.query(sql, new BeanHandler<Employee>(Employee.class), emp.getUserId(), emp.getUserPw());
	}

}
