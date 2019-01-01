package com.octopus.seviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.octopus.dao.EmployeeDao;
import com.octopus.dao.Impl.EmployeeDaoImpl;
import com.octopus.entity.Employee;
import com.octopus.service.EmployeeService;
import com.octopus.utils.DButils;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public List<Employee> list(Employee emp) {

		try {

			// 把复杂的代码放到业务逻辑层来写
			StringBuilder sql = new StringBuilder(
					"SELECT e.*, d.departmentName from employee e,department d where e.departmentId=d.departmentId");

			// 存放参数
			List<Object> arr = new ArrayList<>();

			// 选项判断,员工编号---员工姓名---员工账号
			if (emp != null) {

				// 员工编号
				if (emp.getEmployeeId() != null && emp.getEmployeeId() != 0) {
					sql.append(" and e.employeeId = ?");
					arr.add(emp.getEmployeeId());
				}
				// 员工姓名(注意字符串比较使用equals) 不为空不为空值

				// 员工姓名使用模糊查询
				if (emp.getEmployeeName() != null && !"".equals(emp.getEmployeeName())) {
					sql.append(" and e.employeeName like ?");
					arr.add("%" + emp.getEmployeeName() + "%");
				}

				// 员工账号
				if (emp.getUserId() != null && !"".equals(emp.getUserId())) {
					sql.append(" and e.userId = ?");
					arr.add(emp.getUserId());
				}

			}

			sql.append(" order by e.employeeId desc");

			return dao.list(sql.toString(), arr.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 员工信息添加
	 */
	@Override
	public boolean add(Employee emp) {

		try {

			String sql = "insert into employee (departmentId,employeeName,employeeSex,employeeAge,employeePhone,employeeTime,userId,userPw) values(?,?,?,?,?,?,?,?)";

			List<Object> list = new ArrayList<>();

			if (emp != null) {

				// 和上面的参数顺序要对应
				list.add(emp.getDepartmentId());
				list.add(emp.getEmployeeName());
				list.add(emp.getEmployeeSex());
				list.add(emp.getEmployeeAge());
				list.add(emp.getEmployeePhone());
				list.add(emp.getEmployeeTIme());
				list.add(emp.getUserId());
				list.add(emp.getUserPw());

			}

			return DButils.updateOrder(sql, list.toArray());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	// 根据员工编号获取单条信息
	public Employee getEmployee(Employee emp) {

		try {

			return dao.getEmployee(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 修改员工信息，更新操作
	 */
	@Override
	public boolean update(Employee emp) {

		try {

			String sql = "update employee set departmentId=?,employeeName=?,employeeSex=?,employeeAge=?,employeePhone=?,employeeTime=?,userId=?,userPw=? where employeeId=?";

			List<Object> list = new ArrayList<>();

			if (emp != null) {

				// 和上面的参数顺序要对应
				list.add(emp.getDepartmentId());
				list.add(emp.getEmployeeName());
				list.add(emp.getEmployeeSex());
				list.add(emp.getEmployeeAge());
				list.add(emp.getEmployeePhone());
				list.add(emp.getEmployeeTIme());
				list.add(emp.getUserId());
				list.add(emp.getUserPw());
				list.add(emp.getEmployeeId());

			}

			return DButils.updateOrder(sql, list.toArray());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 删除
	 */
	public boolean delete(Employee emp) {

		try {

			String sql = "delete from  employee where employeeId=?";

			List<Object> list = new ArrayList<>();

			if (emp != null) {

				// 和上面的参数顺序要对应

				list.add(emp.getEmployeeId());

			}

			return DButils.updateOrder(sql, list.toArray());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;

	}

	  /**
     *  登陆验证
     */
	@Override
    public Employee isLogin(Employee emp) {

     try {
		
    	 return dao.isLogin(emp);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return null;
	}
  

}
