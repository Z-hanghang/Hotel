package dao.mainfrm.consume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.consumeaout.AccountVO;
import vo.consumeaout.ConsumeVO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

public class JieSuanDao {
	/**
	 * 根据房号在入住表中查询顾客信息
	 * 
	 * @return
	 */
	public Vector findResideMessage(ResideVO vo) {
		Vector resultVector = new Vector();
		String sql = new String(
				"select re.Reside_id,re.Customer_id,ct.Customer_name,re.Member_id,re.Roomtype_id,re.Deposit,rt.Roomtype_piece,re.Reside_rtime,re.Reside_ltime"
						+ " from Customer ct,Reside re,Roomtype rt"
						+ " where re.Customer_id=ct.Customer_id and re.Room_id='" + vo.getRoomID()
						+ "' and re.Checkout_state='0' and rt.Roomtype_id=(select Roomtype_id from Room where Room_id='"
						+ vo.getRoomID() + "')");
		// 入住订单号，顾客id,顾客姓名，顾客类型id, 房间类型id，押金,房间价格,入住时间，退房时间
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				resultVector.add(rs.getString(1));
				resultVector.add(rs.getString(2));
				resultVector.add(rs.getString(3));
				resultVector.add(rs.getString(4));
				resultVector.add(rs.getString(5));
				resultVector.add(rs.getString(6));
				resultVector.add(rs.getString(7));  // 押金
				resultVector.add(rs.getDate(8));  //入住时间
				resultVector.add(rs.getDate(9));  //退房时间
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st);
		}
		return resultVector;
	}

	/**
	 * 根据房间号在房间消费信息表中查询信息
	 */
	public Vector findConMessageByRoom(ConsumeVO vo) {
		Vector resultVector = new Vector();
		String sql = "select Consume_count from Consume where Consume_state='0' and Room_id='" + vo.getRoom_id() + "'";
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				resultVector.add(rs.getDouble(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st);
		}
		return resultVector;
	}

	/**
	 * 插入一条结算信息
	 */
	public void insertAccount(AccountVO vo) {
		String sql = "insert into Account values " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, vo.getAccount_id());
			ps.setString(2, vo.getReside_id());
			ps.setString(3, vo.getCustomer_id());
			ps.setString(4, vo.getMember_id());
			ps.setString(5, vo.getRoom_id());
			ps.setString(6, vo.getRoomtype_id());
			ps.setString(7, vo.getEmployee_id());
			ps.setDouble(8, vo.getAccount_money());
			ps.setDouble(9, vo.getDeposit());
			ps.setDouble(10, vo.getReturn_deposit());
			ps.setString(11, vo.getAccount_state());
			ps.setString(12, vo.getAccount_txt());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	/**
	 * 更新入住信息
	 */
	public void updateRuZhuMessage(ResideVO vo) {
		String sql = "update Reside set Checkout_state='1' where Room_id='"+vo.getRoomID()+"'";
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
	/**
	 *更新房间商品消费信息
	 */
	public void updateRoomConsume(ConsumeVO vo) {
		String sql = "update Consume set Consume_state='1' where Room_id='"+vo.getRoom_id()+"'";
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
	/**
	 * 更改房间的房间状态
	 * 
	 * @param vo
	 */
	public void updateRoomState(RoomVO vo) {
		String sql = "update Room set Roomstate_id ='RS04' where Room_id='" + vo.getRoomId() + "'";
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
	/**
	 * 更改顾客类型
	 */
	public void updateCustomerType(CustomerVO vo) {
		String sql = "update Customer set Member_id ='"+vo.getMemberId()+"' where Customer_id='" + vo.getCustomerID() + "'";
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
	/**
	 * 插入一条会员记录
	 */
	public void insertVIPMe(CustomerVO vo) {
		String sql = "insert into VIP values(?, ?, ?) ";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getVipId());
			ps.setString(2, vo.getCustomerID());
			ps.setString(3, vo.getMemberId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}
	/**
	 * 更新一条会员信息
	 */
	public void updateVIPMe(CustomerVO vo) {
		String sql = "update VIP set Member_id ='"+vo.getMemberId()+"' where Customer_id='"+vo.getCustomerID()+"'";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getVipId());
			ps.setString(2, vo.getCustomerID());
			ps.setString(3, vo.getMemberId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}
}
