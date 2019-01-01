package com.octopus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;

import com.my.web.servlet.RequestBeanUtils;
import com.octopus.entity.Department;
import com.octopus.entity.Employee;
import com.octopus.service.DepartmentService;
import com.octopus.service.EmployeeService;
import com.octopus.seviceImpl.DepartmentServiceImpl;
import com.octopus.seviceImpl.EmployeeServiceImpl;
import com.octopus.utils.MyDateConverter;

/**
 * Servlet implementation class EmployeeAddServlet
 */
@WebServlet("/employeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 传入业务逻辑层对象引用
		DepartmentService dService = new DepartmentServiceImpl();
		List<Department> list = dService.list(null);
		request.setAttribute("list", list);

		request.getRequestDispatcher("/view/employee/employeeAdd.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//对接收到的日期信息进行处理
		ConvertUtils.register(new MyDateConverter(), java.util.Date.class);
		// 员工信息添加
		// RequestBeanUtils使用该类使request和实体类相对应
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);

		EmployeeService es = new EmployeeServiceImpl();

		boolean res = es.add(emp);

		if (res) {

			request.setAttribute("info", "添加员工信息成功");
		} else {

			request.setAttribute("info", "添加员工信息失败");
		}
		
		request.getRequestDispatcher("/view/employee/employeeInfo.jsp").forward(request, response);

	}

}
