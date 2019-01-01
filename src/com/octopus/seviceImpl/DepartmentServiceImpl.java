package com.octopus.seviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.octopus.dao.DepartmentDao;
import com.octopus.dao.Impl.DepartmentDaoImpl;
import com.octopus.entity.Department;
import com.octopus.service.DepartmentService;
import com.octopus.utils.DButils;

public class DepartmentServiceImpl implements DepartmentService {

	// dao层引用
	private DepartmentDao dao = new DepartmentDaoImpl();

	public List<Department> list(Department de) {
		try {
			// departmentMark在这里是个标志，指的是为被删除的元素，这是为了保持数据库不会删除元素
			StringBuilder sql = new StringBuilder("select * from department where departmentMark=1");

			// 查询条件(数组)
			List<Object> params = new ArrayList<>();

			if (de != null) {
				// 如果前台的信息不为空，且不等于空值
				if (de.getDepartmentName() != null && !"".equals(de.getDepartmentName())) {
					// sql语句增加一个参数
					sql.append(" and departmentName like ?");
					// 这个是数组的元素，对应着的是上面的？参数
					params.add("%" + de.getDepartmentName() + "%");

				}
				// 部门编号
				if (de != null) {
					// 部门名称
					if (de.getDepartmentName() != null && !"".equals(de.getDepartmentName())) {
						sql.append(" and departmentName like ?");
						params.add("%" + de.getDepartmentName() + "%");
					}

					// 部门编号
					if (de.getDepartmentId() != null && de.getDepartmentId() != 0) {
						sql.append(" and departmentId = ?");
						params.add(de.getDepartmentId());
					}
				}

				// 更新数据，倒序显示
				sql.append(" order by departmentId desc");

			}
			// 对应着dao层的方法，传入的sql由于是stringbulder需要变为string， params是arraylist需要变为普通数组
			return dao.list(sql.toString(), params.toArray());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 添加部门信息
	 */
	@Override
	public boolean add(Department de) {
		try {

			// sql
			String sql = "insert into department (departmentName,departmentDesc,departmentMark) values (?,?,?)";
			// 参数
			List<Object> list = new ArrayList<>();
			// list数组的顺序要和上面参数的顺序要一一对应的
			if (de != null) {

				list.add(de.getDepartmentName());

				list.add(de.getDepartmentDesc());
				list.add("1");

			}
			return DButils.updateOrder(sql, list.toArray());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

	// 根据编号ID查询单条信息
	@Override
	public Department getDepartment(Department de) {

		try {
			return dao.getDepartment(de);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 修改部门信息
	@Override
	public boolean update(Department de) {
		try {
			// SQL
			String sql = "update  department set departmentName=?,departmentDesc=?,departmentMark=? where departmentId=?";
			// 参数
			List<Object> list = new ArrayList<Object>();

			if (de != null) {
				// 部门名称
				list.add(de.getDepartmentName());
				list.add(de.getDepartmentDesc());
				list.add("1");
				list.add(de.getDepartmentId());
			}

			return DButils.updateOrder(sql, list.toArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Department de) {
	    
		try {
			// SQL
			String sql = "update  department set departmentMark=? where departmentId=?";
			// 参数
			List<Object> list = new ArrayList<Object>();

			if (de != null) {
				//只是改变状态码，1表示存在，0表示删除
				list.add("0");
				list.add(de.getDepartmentId());
			}

			return DButils.updateOrder(sql, list.toArray());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
