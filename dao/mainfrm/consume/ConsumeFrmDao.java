package dao.mainfrm.consume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import view.mainfrm.consume.FrmConsume;
import vo.consumeaout.ConsumeVO;
import vo.consumeaout.FoodVO;
import vo.consumeaout.FoodstockVO;
import vo.consumeaout.ResideVO;

public class ConsumeFrmDao {

	/**
	 * �����������Ʒ����ѯ��Ʒ��Ϣ ���ѯ������Ʒ��Ϣ
	 * 
	 * @param vo
	 * @return
	 */
	public Vector<Vector> findShangPinByShangPinMing(FoodVO vo) {
		Vector<Vector> resultVector = new Vector<Vector>();

		StringBuilder sql = new StringBuilder("select Food_id,Food_name,Food_piece,"
				+ "Foodstock_amount from Food f,Foodstock fs where f.Foodstock_id = fs.Foodstock_id");
		String shangPinMing = vo.getFood_name();
		if (shangPinMing != null && !shangPinMing.equals("")) {
			sql.append(" and Food_name like '%" + shangPinMing + "%'");
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
				v.add(rs.getInt(4));

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

	/**
	 * ���ݷ��Ų�����ס��Ϣ
	 * 
	 * @param vo
	 * @return
	 */
	public Vector ruZhuMessage(ResideVO vo) {
		Vector resultVector = new Vector();
		String sql = "select Reside_rtime,Roomtype_piece * round(Reside_ltime - Reside_rtime)"
				+ " + nvl((select sum(Consume_count) from Consume " + "where Room_id = '" + vo.getRoom_id()
				+ "' and Consume_state='0' group by Room_id),0)" + ",Deposit from reside re ,Roomtype ro "
				+ "where re.Roomtype_id = ro.Roomtype_id " + "and re.Room_id = '" + vo.getRoom_id() + "' "
				+ "and re.Checkout_state = '0'";

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			while (rs.next()) {
				resultVector.add(rs.getString(1));
				resultVector.add(rs.getString(2));
				resultVector.add(rs.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}
		return resultVector;
	}

	/**
	 * ���ݷ���Ų��ҹ˿ͷ���������Ϣ
	 * 
	 * @return
	 */
	public Vector findRoomConsume(ConsumeVO vo) {
		Vector resultVector = new Vector();
		String sql = new String("select f.Food_name,c.Consume_number,c.Consume_count from Food f,Consume c "
				+ "where c.Food_id=f.Food_id and c.Room_id='" + vo.getRoom_id() + "' and Consume_state='0'");
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
				
				resultVector.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.free(conn, st, rs);
		}
		return resultVector;
	}

	/**
	 * ���ݷ���Ų�ѯ�˿ͱ��
	 * @param vo
	 * @return
	 */
	public String findCustomerM(ResideVO vo) {
		String s = new String();
		String sql = "select Customer_id from Reside where Checkout_state='0' and Room_id='" + vo.getRoom_id() + "'";
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

	/**
	 * ������Ʒ����ѯ��Ʒ���
	 * @param vo
	 * @return
	 */
	public String findFoodId(FoodVO vo) {
		String s = new String();
		String sql = "select food_id from Food where food_name='"+vo.getFood_name()+"'";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.free(conn, st, rs);
		}
		return s;
	}
	/**
	 * ����һ������������Ϣ
	 * 
	 * @param frmConsume
	 */
	public void insertConsume(ConsumeVO vo) {
		String sql = "insert into Consume values " + "(?, ?, ?, ?, sysdate, ?, ?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRoom_id());
			ps.setString(2, vo.getCustomer_id());
			ps.setString(3, vo.getFood_id());
			ps.setInt(4, vo.getConsume_number());
			//ps.setDate(5, new java.sql.Date(vo.getConsume_date().getTime()));
			ps.setString(5, vo.getConsume_state());
			ps.setDouble(6, vo.getCustomer_count());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}

	/**
	 * �������ѱ���Ϣ
	 * 
	 * @param vo
	 */
	public void updateConsume(ConsumeVO vo) {
		String sql = "update Consume set " + "Consume_number="+vo.getConsume_number()+"," 
	       + "Consume_date=sysdate," + "Consume_count="+vo.getCustomer_count()+" where Food_id='"+vo.getFood_id()+"'";

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
	 * ������Ʒ�����Ϣ
	 */
	public void updateFoodstock(FoodVO vo1,FoodstockVO vo2) {
		String sql = "update Foodstock set Foodstock_amount="+vo2.getFoodstock_amount()
		+" where Foodstock_id = (select Foodstock_id from food where food_id='"+vo1.getFood_id()+"')";

		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);		

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.free(conn, ps);
		}
	} 
}
