package dao.mainfrm.changeroomfrm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.CsrecordVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomTypeVO;
import vo.mainfrm.RoomVO;
/**
 * 更改房间功能的主要DAO层
 * @author 吴阿龙
 *
 */
public class ChangeRoomFrmDAO {

	/**
	 * 查找同类型的房间数
	 */
	public Vector FindSameTypeRoom(RoomTypeVO vo) {
		Vector resultVector = new Vector();
		String sql = new String("select ro.Room_id, rt.Roomtype_piece from Room ro, RoomType rt "
				+ "where ro.Roomtype_id=rt.Roomtype_id and rt.Roomtype_name ='" + vo.getRoomTypeName()
				+ "' and Roomstate_id='RS01'");

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String[] v = new String[2];
				v[0] = (rs.getString(1));
				v[1] = (rs.getString(2));

				resultVector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}
		// System.out.println(sql);
		return resultVector;
	}
	/**
	 * 查找入住表中房间号对应的顾客编号
	 */
	public String findCustomerId(ResideVO vo) {
		String s = new String();
		String sql = new String("select Customer_id from Reside where Room_id='"+vo.getRoomID()+"'");
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				s = (rs.getString(1));
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}finally {
			DBManager.free(conn, st, rs);
		}
		return s;
		
	}

	/*
	 * 插入换房记录表的信息
	 */
	public void insertCsrecord(CsrecordVO vo) {
		String sql = "insert into Csrecord values " + "(?, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getcSrecordId());
			ps.setString(2, vo.getCustomerId());
			ps.setString(3,vo.getRoomId());
			ps.setString(4,vo.getBeforeRoomId());
			ps.setDate(5, new java.sql.Date(vo.getCSrecordDate().getTime()));

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	/**
	 * 更改房间的房间状态
	 * 
	 * @param vo
	 */
	public void updateRoomState(RoomVO vo) {
		String sql = "update Room set Roomstate_id ='"+vo.getRoomStateId()+"' where Room_id='" + vo.getRoomId() + "'";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		// 旧房间的房间状态
		try {
			// System.out.println(sql2);
			ps = conn.prepareStatement(sql);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 新房间的房间状态
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}

	}

	/**
	 * 修改入住信息表
	 * 
	 * @param vo
	 * @param newRoom
	 */
	public void updateReside(ResideVO vo, String newRoom) {
		String sql = "update Reside set Room_id ='" + newRoom + "' where Room_id='" + vo.getRoomID() + "' and Checkout_state='0'";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

}
