package dao.mainback.employee;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import common.jdbc.DBManager;
import common.jdbc.ExceptionChuLi;
import vo.mainback.Employee;

/*��ѯԱ������
* �ɲ�ѯ����Ա����Ϣ���ɸ�������ģ����ѯԱ������Ϣ��
* �ɸ��ݱ��ģ����Ա������Ϣ��
* �ɸ��ݱ�ź�������ȷ��ĳԱ������Ϣ.
* ɾ��Ա������
* ����Ա�����ɾ����Ӧ��Ա����Ϣ��
* ����Ա������
* ����Ա����Ϣ��Ա������.
* ����Ա������
* ����Ա����Ϣ��Ա������.
* @author:�ź�
* @date:2018.10.17
*/
public class jdbcEmployeeManage {
 private StringBuffer sqlSelect=new StringBuffer("select em.employee_id,e.emtype_name,em.employee_name,em.employee_birthday,em.employee_sex,em.employee_tel,em.employee_eid from emtype e,employee em where e.emtype_id = em.emtype_id");
 
	//private StringBuffer sqlSelect=new StringBuffer("select * from Employee where");
	// ��ѯ����Ա������Ϣ
	public Vector<Vector> findAlleEmployee() {
		String sql="select em.employee_id,e.emtype_name,em.employee_name,em.employee_birthday,em.employee_sex,em.employee_tel,em.employee_eid from emtype e,employee em where e.emtype_id = em.emtype_id order by em.employee_id ASC";
		return this.findEmployee(sql);

	}
	/**********************************************/
	// ����������ĳԱ������Ϣ
	public Vector<Vector> findNameEmployee(Employee em) {
		
		String name = em.getEmployeeName();
		
		if (name != null && !name.equals("")) {
			sqlSelect.append(" and Employee_name like '%" + name + "%'");
		}
		return this.findEmployee(sqlSelect.toString());
	}
	/**********************************************/
	// ���ݱ�Ų�ĳԱ������Ϣ
	public Vector<Vector> findIDEmployee(Employee em) {
		String id = em.getEmployeeId();
		if (id != null && !id.equals("")) {
			sqlSelect.append(" and Employee_id like '%" + id + "%'");
		}
		return this.findEmployee(sqlSelect.toString());
	}
	/**********************************************/
	// ���ݱ�ź�������ȷ��ĳԱ������Ϣ
	/*public Vector<Vector> findNameIDEmployee(Employee em) {
		String id = em.getEmployeeId();
		String name = em.getEmployeeName();
		if ((name != null && !name.equals(""))&&(id != null && !id.equals(""))){
			sqlSelect.append("and Employee_name like '%" + name + "%' and Employee_id like '%"+ id + "%';");
		}

		return this.findEmployee(sqlSelect.toString());
	}*/
	/**********************************************/
	// ɾ��Ա��
	public void deleteEmployee(Employee em) {
		String sql = "delete Employee where Employee_id = '" + em.getEmployeeId() + "'";

		Connection conn = DBManager.getConnection();
		Statement st = null;

		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			 ExceptionChuLi.DeteclChuLi();
//			 e.printStackTrace();
		} finally {
			DBManager.free(conn, st);
		}
	}
	/**********************************************/
	// ����Ա��
	public void insertEmployee(Employee em) {
		java.sql.Date sd;
		java.util.Date ud= em.getEmployeeBrithday();
		sd = new java.sql.Date(ud.getTime());
		String sql = "insert into Employee values " + "(?, ?, ?, ?, ?, ?,?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, em.getEmployeeId());
			ps.setString(2, em.getEmtypeId());
			ps.setString(3, em.getEmployeeName());
			ps.setDate(4,  sd);
			ps.setString(5, em.getEmployeeSex());
			ps.setString(6, em.getEmployeeTel());
			ps.setString(7, em.getEmployeeEid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}
	/**********************************************/
	//����Ա����Ϣ
	public void updateEmployee(Employee em) {
		java.sql.Date sd;
		java.util.Date ud= em.getEmployeeBrithday();
		sd = new java.sql.Date(ud.getTime());
	    String sql = "update Employee set "
	      + "EMtype_id = ?, "
	      + "Employee_name = ?, "
	      + "Employee_birthday = ?, "
	      + "Employee_sex = ?, "
	      + "Employee_tel = ?, " 
	      + "Employee_eID = ?"
	      + "where Employee_id = ?";
	    Connection conn = DBManager.getConnection();
	    PreparedStatement ps = null;
	    try {
	      ps = conn.prepareStatement(sql);
	      ps.setString(1, em.getEmtypeId());
	      ps.setString(2, em.getEmployeeName());
		  ps.setDate(3,sd);
		  ps.setString(4, em.getEmployeeSex());
		  ps.setString(5, em.getEmployeeTel());
		  ps.setString(6, em.getEmployeeEid());
		  ps.setString(7, em.getEmployeeId());
	      ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } finally {
	    	DBManager.free(conn, ps);
	    }
	  }

	/*********************************************************	
	 
	 ********************************************************/
	// ��ѯԱ�������ݵ�˽�з���
	private Vector<Vector> findEmployee(String sql) {
		Vector<Vector> resultVector = new Vector<Vector>();
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				Vector v = new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getString(3));
				v.add(rs.getDate(4));
				v.add(rs.getString(5));
				v.add(rs.getString(6));
				v.add(rs.getString(7));
				

				resultVector.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return resultVector;
	}

}
