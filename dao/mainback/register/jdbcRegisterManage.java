package dao.mainback.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

import common.jdbc.DBManager;
import common.jdbc.ExceptionChuLi;
import vo.mainback.Register;

/*��¼Ȩ�޹���
 * ��ɾ�Ĳ�
 * */
public class jdbcRegisterManage {

	// ͨ��Ա�����ɾ����¼��
	public void deleteLogByFK(Register vo) {
		String sql = "delete log where employee_id = '" + vo.getEmployeeId() + "'";

		Connection conn = DBManager.getConnection();
		Statement st = null;

		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			ExceptionChuLi.DeteclChuLi();
//			e.printStackTrace();
		} finally {
			DBManager.free(conn, st);
		}
	}

	// �����¼��
	public void insertRegister(Register vo) {
		String sql = "insert into log values (?, ?, ?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getEmployeeId());
			ps.setString(2, "null");
			ps.setString(3, "0");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}

	}

	// ����״̬����Ϊ1
	public void updatelogState1(Register vo) {
		String sql = "update Log set log_state= '1' where employee_id = ?";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	// ����״̬����Ϊ0
	public void updatelogState0(Register vo) {
		String sql = "update Log set log_state= '0' where employee_id = ?" ;

				
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	// ��������
	public void updatelogPassWord(Register vo) {
		String sql = "update Log set log_password = ? where employee_id =?";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRegisterPassword());
			ps.setString(2, vo.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	//��ѯ����Ա��
	public Vector<String> findAllEmployee() {
		

		String sql = "select  e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ";

		return findRegister(sql);
	}

	// ��Ա�����ģ����ѯ
	public Vector<String> selectEmployeeId(Register vo) {

		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		String employeeid = vo.getEmployeeId();
		if (employeeid != null && !employeeid.equals("")) {
			sql.append("and e.employee_id like '%"+ employeeid + "%'");
		}
		return findRegister(sql.toString());

	}

	// ������ģ����ѯ
	public Vector<String> selectEemployeeName(Register vo) {

		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		String employename = vo.getEmployeeName();
		if (employename != null && !employename.equals("")) {
			sql.append("and e.employee_name like '%" + employename + "%'");
		}

		return findRegister(sql.toString());

	}

	// �������ͱ�Ų���
	public Vector<String> selectEmployeeNameId(Register vo) {
		String employename = vo.getEmployeeName();
		String employeeid = vo.getEmployeeId();
		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		if ((employeeid != null && !employeeid.equals("")) && (employename != null && !employename.equals(""))) {
			sql.append("and employee_id like '%" + employeeid + "%' and employee_name like '%" + employename + "%'");
		}
		return findRegister(sql.toString());
	}

	// ��ѯ��¼���Ա����˽�з���
	private Vector<String> findRegister(String sql) {
		Vector resultVector = new Vector();
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
				v.add(rs.getString(4));

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
	//��ѯ��������Ϊ�յ�Ա����
	public TreeSet SelectpwdNull(){
		String sql=" select employee_id from log where log_password='null' ";
	    return SelectLogId(sql);
	}
	//��ѯ�������벻Ϊ�յ�Ա����
	public TreeSet  SelectpwdNotNull(){
		String sql=" select employee_id from log where log_password!='null' ";
	    return SelectLogId(sql);
	}
	/*******************************/
	//��ѯԱ����˽�з���
	private TreeSet<Register>  SelectLogId(String sql) {
		TreeSet<Register>  resultVector = new TreeSet<Register>  ();
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
       // String sql=" select employee_id from log where log_password='null' ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Register vo	=new Register();
				vo.setEmployeeId(rs.getString(1));
				TreeSet<Register>   v = new TreeSet<Register>  ();
			    v.add(vo);
			
				resultVector.addAll(v);
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
