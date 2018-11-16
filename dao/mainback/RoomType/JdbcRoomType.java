package dao.mainback.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Vector;

import common.jdbc.DBManager;
import common.jdbc.ExceptionChuLi;
import vo.mainback.Roomvo;

/**
 * 房间类型jdbc增删改查
 * 
 **/
public class JdbcRoomType {
	// 查出所有的房间类型名
	public Vector<String> SelectAllRoomTypeName() {
		Vector<String> h = new Vector<String>();

		String sql = "select roomtype_name from roomtype ";

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Vector<String> v = new Vector<String>();
				v.add(rs.getString(1));

				h.addAll(v);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return h;
	}

	// 按姓名查找
	public Vector findRoomTypeByRoomTypename(Roomvo vo) {
		Vector resultVector = new Vector();

		StringBuilder sql = new StringBuilder("select * from roomtype r  ");

		String roomtypename = vo.getRoomtypename();
		if (roomtypename != null && !roomtypename.equals("")) {
			sql.append(" where r.roomtype_name like '%" + roomtypename + "%'");
		}
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getDouble(3));

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

	// 按价格查找
	public Vector findRoomTypeByRoomTypepiece(String s1, String s2) {
		Vector resultVector = new Vector();

		StringBuilder sql = new StringBuilder("select * from roomtype r ");

		double a = Integer.parseInt(s1);
		double b = Integer.parseInt(s2);
		if (s1 != null && !s1.equals("") && s2 != null && !s2.equals("")) {
			sql.append(" where r.roomtype_piece between " + a + " and " + b);
		}

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				v.add(rs.getDouble(3));

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

	// 通过编号删除
	public void deleteRoomTypeByPK(Roomvo vo) {
		String sql = "delete roomtype where roomtype_id = '" + vo.getRoomtypeid() + "'";

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

	// 查找全部
	public Vector findAllRoomType() {
		Vector resultVector = new Vector();

		String sql = "select * from roomtype";

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
				v.add(rs.getDouble(3));

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

	// 插入房间类型
	public void insertRoomType(Roomvo vo) {
		String sql = "insert into roomtype values(?, ?, ?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRoomtypeid());
			ps.setString(2, vo.getRoomtypename());
			ps.setDouble(3, vo.getRoompiece());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	// 修改房间类型信息
	public void updateRoomTypeByPK(Roomvo vo) {
		String sql = "update roomtype set roomtype_name= ?,roomtype_piece= ? where roomtype_id = ?";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRoomtypename());
			ps.setDouble(2, vo.getRoompiece());
			ps.setString(3, vo.getRoomtypeid());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}
	//根据房间类型名查找房间类型编号
	public String SelectRoomTypeID(String RoomTypeName) {
		String a=null;

		String sql = "select roomtype_id from roomtype  where roomtype_name='"+RoomTypeName+"'";

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				a=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return a;
	}
	
}
