package com.octopus.servlet;

import java.io.IOException;
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
 * Servlet implementation class DepartmentAddServlet
 */
@WebServlet("/departmentAddServlet")
public class DepartmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentAddServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 获取页面的数据(使用这个需要和表单name相对应)将表单提交的数据封装到javabean中的实体类中
		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);

		DepartmentService dService = new DepartmentServiceImpl();

		boolean res = dService.add(de);

		if (res) {

			request.setAttribute("info", "添加部门信息成功");

		} else {

			request.setAttribute("info", "添加部门信息失败");

		}

		request.getRequestDispatcher("/view/department/departmentInfo.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
