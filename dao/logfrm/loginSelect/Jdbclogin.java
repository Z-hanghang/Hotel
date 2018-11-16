package dao.logfrm.loginSelect;

/**
 *登录获取账户密码
 * @author: 张航
 * @date:2018.10.16
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.jdbc.DBManager;
import vo.mainback.Manager;
import vo.mainback.Register;


/*登录访问数据库获取 用户ID， 姓名，密码
 * */
public class Jdbclogin {
//从登录表中查找
	public Register findUser(String id,String pwd) {
		String sql = "select e.employee_id,e.employee_name,l.log_password from log l,employee e where l.employee_id=e.employee_id and l.employee_id=? and l.log_password=? ";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Register user=new Register();

		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setEmployeeId(rs.getString(1));
				user.setEmployeeName(rs.getString(2));
				user.setRegisterPassword(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放对象资源
			DBManager.free(conn, ps, rs);

		}
		return user;

	}
	//从管理员表中查找
	public Manager findManager(String id,String pwd) {
		String sql = "select * from Manager where Manager_id = ? and Manager_pwd = ?";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Manager manager=new Manager();
		
		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				manager.setManagerName(rs.getString(1));
				manager.setManagerId(rs.getString(2));
				manager.setManagerPwd(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// 释放对象资源
			DBManager.free(conn, ps, rs);
			
		}
		return manager;
		
	}

}
