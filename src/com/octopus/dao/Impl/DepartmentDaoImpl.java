package com.octopus.dao.Impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.octopus.dao.DepartmentDao;
import com.octopus.entity.Department;
import com.octopus.utils.DButils;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public List<Department> list(String sql, Object[] arr) throws Exception {

		QueryRunner qr = DButils.getQueryRunner();
		System.out.println(sql);
		for (Object object : arr) {
			System.out.println(object.toString());

		}
		// 传入sql语句，将mysql属性的参数和实体类的属性对应，然后将arr数组的值按顺序传入sql的参数中
		List<Department> sList = qr.query(sql, new BeanListHandler<Department>(Department.class), arr);
		for (Department department : sList) {

			System.out.println(department.toString());
		}
		return sList;

		/*
		 * 把结果集转为一个 Bean 的 List, 并返回. Bean 的类型在 创建 BeanListHanlder 对象时以 Class 对象的方式传入.
		 * 可以适应列的别名来映射 JavaBean 的属性名:
		 */
	}

	// 根据编号ID查询单条信息
	@Override
	public Department getDepartment(Department de) throws Exception {

		String sql = "select * from department where departmentMark=1 and departmentId=?";
		QueryRunner qRunner = DButils.getQueryRunner();
       
		//这里不要使用BeanHandler的list，只有一个参数，后面直接把参数对应上去就可以了
		return qRunner.query(sql, new BeanHandler<>(Department.class), de.getDepartmentId());
	}

}
