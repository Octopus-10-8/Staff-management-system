package com.octopus.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.web.servlet.RequestBeanUtils;
import com.octopus.entity.Employee;
import com.octopus.service.EmployeeService;
import com.octopus.seviceImpl.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeDeleteServlet
 */
@WebServlet("/employeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EmployeeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);

		EmployeeService es = new EmployeeServiceImpl();

		boolean res = es.delete(emp);

		if (res) {

			request.setAttribute("info", "删除员工信息成功");
		} else {

			request.setAttribute("info", "删除员工信息失败");
		}

		request.getRequestDispatcher("/view/employee/employeeInfo.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doGet(request, response);
	}

}
