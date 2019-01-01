package com.octopus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.octopus.entity.Department;
import com.octopus.service.DepartmentService;
import com.octopus.seviceImpl.DepartmentServiceImpl;

/**
 * Servlet implementation class DepartmentQuery
 */
@WebServlet("/DepartmentQuery")
public class DepartmentQuery extends HttpServlet {

	// 传入业务逻辑层对象引用
	DepartmentService dService = new DepartmentServiceImpl();

	public DepartmentQuery() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// 部门编号

		// 部门名称

		/*
		 * Department department = new Department(); // 需要转换为十进制数字
		 * department.setDepartmentId(Integer.valueOf(departmentId));
		 * 
		 * department.setDepartmentName(departmentName);
		 * 
		 * List<Department> departments=dService.list(department);
		 * 
		 * System.out.println(departments.size());
		 */

		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);
		
		List<Department> list = dService.list(de);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/view/department/departmentQuery.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
