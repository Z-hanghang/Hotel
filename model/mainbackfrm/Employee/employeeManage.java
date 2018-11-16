package model.mainbackfrm.Employee;

import java.util.Vector;
import dao.mainback.employee.jdbcEmployeeManage;
import vo.mainback.Employee;

/* employeeManage ҵ���߼���Ա������ 
 * ��ɾ���
 * @author:�ź�
 * @date:2018.10.17
 * 
 * */
public class employeeManage {
	private jdbcEmployeeManage jdbcem = new jdbcEmployeeManage();
	//�������е�Ա����Ϣ
	public Vector<Vector> findAlleEmployee(){
		return jdbcem.findAlleEmployee();
	}

	// ����������ĳԱ������Ϣ
	public Vector selectNameEmployee(Employee em) {
		return jdbcem.findNameEmployee(em);
	}

	// ���ݱ�Ų�ĳԱ������Ϣ
	public Vector selectIdEmployee(Employee em) {
		return jdbcem.findIDEmployee(em);
	}

	// ���ݱ�ź�������ȷ��ĳԱ������Ϣ
/*	public Vector selectIdNameEmployee(Employee em) {
		return jdbcem.findNameIDEmployee(em);
	}
*/
	// ɾ��Ա��
	public void delectEmployee(Employee em) {
		jdbcem.deleteEmployee(em);
	}

	// ����Ա��
	public void addEmployee(Employee em) {
		jdbcem.insertEmployee(em);
	}

	// ����Ա����Ϣ
	public void updateEmployee(Employee em) {
		jdbcem.updateEmployee(em);
	}
}
