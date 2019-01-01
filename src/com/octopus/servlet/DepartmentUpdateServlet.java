package com.octopus.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
 * Servlet implementation class DepartmentUpdateServlet
 */
@WebServlet("/departmentUpdateServlet")
public class DepartmentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// 获取页面的数据
		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);

		// 业务逻辑层

		DepartmentService ds = new DepartmentServiceImpl();

		// 根据部门编号查询信息
		Department department = ds.getDepartment(de);
		// 把记录传入request中转发到页面中去
		request.setAttribute("dep", department);
		request.getRequestDispatcher("/view/department/departmentUpdate.jsp").forward(request, response);

	}

	// 这里的POST接收的是修改请求（也可以单独创建一个页面）
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		// 获取页面的数据(使用这个需要和表单name相对应)将表单提交的数据封装到javabean中的实体类中
		Department de = RequestBeanUtils.requestToSimpleBean(request, Department.class);

		DepartmentService dService = new DepartmentServiceImpl();

		boolean res1 = dService.update(de);

		if (res1) {

			request.setAttribute("info", "修改部门信息成功");

		} else {

			request.setAttribute("info", "修改部门信息失败");

		}

		request.getRequestDispatcher("/view/department/departmentInfo.jsp").forward(request, response);

	}

}
