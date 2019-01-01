package com.octopus.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.web.servlet.RequestBeanUtils;
import com.octopus.entity.Department;
import com.octopus.entity.Employee;
import com.octopus.service.EmployeeService;
import com.octopus.seviceImpl.EmployeeServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取页面的数据(使用这个需要和表单name相对应)将表单提交的数据封装到javabean中的实体类中
		// RequestBeanUtils使用该类使request和实体类相对应
		Employee emp = RequestBeanUtils.requestToSimpleBean(request, Employee.class);

		EmployeeService es = new EmployeeServiceImpl();
		Employee empl = es.isLogin(emp);

		// 如果可以查询到结果，说明可以登陆，否则不能登陆
		if (empl != null) {

			// 登陆成功后，把当前对象存到session中
			HttpSession session = request.getSession();
			request.setAttribute("empl", empl);
			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} else {
			request.setAttribute("info", "账号或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
