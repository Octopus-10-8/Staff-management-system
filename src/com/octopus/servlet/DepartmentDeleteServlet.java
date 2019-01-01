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
 * Servlet implementation class DepartmentDeleteServlet
 */
@WebServlet("/departmentDeleteServlet")
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DepartmentDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取页面的数据(使用这个需要和表单name相对应)将表单提交的数据封装到javabean中的实体类中
		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);

		DepartmentService dService = new DepartmentServiceImpl();

		boolean res1 = dService.delete(de);

		if (res1) {

			request.setAttribute("info", "删除部门信息成功");

		} else {

			request.setAttribute("info", "删除部门信息失败");

		}

		request.getRequestDispatcher("/view/department/departmentInfo.jsp").forward(request, response);

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
