package model.mainbackfrm.Employee;

import java.util.Vector;
import dao.mainback.employee.jdbcEmployeeManage;
import vo.mainback.Employee;

/* employeeManage 业务逻辑，员工管理 
 * 增删查改
 * @author:张航
 * @date:2018.10.17
 * 
 * */
public class employeeManage {
	private jdbcEmployeeManage jdbcem = new jdbcEmployeeManage();
	//查找所有的员工信息
	public Vector<Vector> findAlleEmployee(){
		return jdbcem.findAlleEmployee();
	}

	// 根据姓名查某员工的信息
	public Vector selectNameEmployee(Employee em) {
		return jdbcem.findNameEmployee(em);
	}

	// 根据编号查某员工的信息
	public Vector selectIdEmployee(Employee em) {
		return jdbcem.findIDEmployee(em);
	}

	// 根据编号和姓名精确查某员工的信息
/*	public Vector selectIdNameEmployee(Employee em) {
		return jdbcem.findNameIDEmployee(em);
	}
*/
	// 删除员工
	public void delectEmployee(Employee em) {
		jdbcem.deleteEmployee(em);
	}

	// 增加员工
	public void addEmployee(Employee em) {
		jdbcem.insertEmployee(em);
	}

	// 更改员工信息
	public void updateEmployee(Employee em) {
		jdbcem.updateEmployee(em);
	}
}
