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
 * 员工管理信息修改更新
 */
@WebServlet("/employeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 部门管理业务逻辑层
		DepartmentService dService = new DepartmentServiceImpl();
		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);

		List<Department> list = dService.list(de);
		request.setAttribute("list", list);

		// 员工管理的业务逻辑层
		EmployeeService es = new EmployeeServiceImpl();

		// 获取页面信息
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);
		System.out.println("sdddddddddd");
		System.out.println(emp);
		Employee employee = es.getEmployee(emp);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("/view/employee/employeeUpdate.jsp").forward(request, response);

	}

	// 这里的POST接收的是修改请求（也可以单独创建一个页面）
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// 对接收到的日期信息进行处理
		ConvertUtils.register(new MyDateConverter(), java.util.Date.class);
		// 员工信息添加
		// RequestBeanUtils使用该类使request和实体类相对应
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);

		EmployeeService es = new EmployeeServiceImpl();

		boolean res = es.update(emp);

		if (res) {

			request.setAttribute("info", "修改员工信息成功");
		} else {

			request.setAttribute("info", "修改员工信息失败");
		}

		request.getRequestDispatcher("/view/employee/employeeInfo.jsp").forward(request, response);

	}

}
