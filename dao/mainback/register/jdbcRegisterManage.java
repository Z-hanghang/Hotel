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

/*登录权限管理
 * 增删改查
 * */
public class jdbcRegisterManage {

	// 通过员工编号删除登录表
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

	// 插入登录表
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

	// 更新状态，改为1
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

	// 更新状态，改为0
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

	// 更新密码
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

	//查询所有员工
	public Vector<String> findAllEmployee() {
		

		String sql = "select  e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ";

		return findRegister(sql);
	}

	// 按员工编号模糊查询
	public Vector<String> selectEmployeeId(Register vo) {

		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		String employeeid = vo.getEmployeeId();
		if (employeeid != null && !employeeid.equals("")) {
			sql.append("and e.employee_id like '%"+ employeeid + "%'");
		}
		return findRegister(sql.toString());

	}

	// 按姓名模糊查询
	public Vector<String> selectEemployeeName(Register vo) {

		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		String employename = vo.getEmployeeName();
		if (employename != null && !employename.equals("")) {
			sql.append("and e.employee_name like '%" + employename + "%'");
		}

		return findRegister(sql.toString());

	}

	// 按姓名和编号查找
	public Vector<String> selectEmployeeNameId(Register vo) {
		String employename = vo.getEmployeeName();
		String employeeid = vo.getEmployeeId();
		StringBuilder sql = new StringBuilder("select e.employee_id,e.employee_name,l.log_password,l.log_state  from employee e,log l  where l.employee_id=e.employee_id ");
		if ((employeeid != null && !employeeid.equals("")) && (employename != null && !employename.equals(""))) {
			sql.append("and employee_id like '%" + employeeid + "%' and employee_name like '%" + employename + "%'");
		}
		return findRegister(sql.toString());
	}

	// 查询登录表和员工表私有方法
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
	//查询所有密码为空的员工号
	public TreeSet SelectpwdNull(){
		String sql=" select employee_id from log where log_password='null' ";
	    return SelectLogId(sql);
	}
	//查询所有密码不为空的员工号
	public TreeSet  SelectpwdNotNull(){
		String sql=" select employee_id from log where log_password!='null' ";
	    return SelectLogId(sql);
	}
	/*******************************/
	//查询员工号私有方法
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
