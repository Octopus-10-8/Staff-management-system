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
import com.octopus.entity.Employee;
import com.octopus.service.EmployeeService;
import com.octopus.seviceImpl.EmployeeServiceImpl;
import com.octopus.utils.MyDateConverter;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/employeeServlet")
public class EmployeeQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeQueryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        //  RequestBeanUtils对于日期无法处理，需要对日期进行相关处理，这里引入了一个工具类来处理
		
		ConvertUtils.register(new MyDateConverter(), java.util.Date.class);
		
		
		// RequestBeanUtils使用该类使request和实体类相对应
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);

		EmployeeService es = new EmployeeServiceImpl();
          
		//根据条件查询员工信息
		List<Employee> list= es.list(emp);
		
		//返回页面
		request.setAttribute("emp", emp);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/employee/employeeQuery.jsp").forward(request, response);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
