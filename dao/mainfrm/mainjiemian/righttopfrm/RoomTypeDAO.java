package dao.mainfrm.mainjiemian.righttopfrm;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.RoomVO;
/**
 * �������Ͳ��Һͷ���״̬���ҵ�DAO��
 * @author �Ⱒ��
 *
 */
public class RoomTypeDAO {
	
	public Vector findAllRoomType() {
		Vector resultVector = new Vector();

		StringBuilder sql = new StringBuilder("select * from Roomtype");
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());

			while(rs.next()) {
				String[] str = new String[2];
				str[0]=rs.getString(1);   //��Ÿ÷���״̬��id
				str[1]=rs.getString(2);   //��ŷ���״̬��

				resultVector.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.free(conn, st, rs);
		}

		return resultVector;
	}
	/**
	 * ���Ҷ�Ӧ����ŵķ���״̬
	 * @return
	 */
	public String findOneRoomState(RoomVO vo) {
		String s = new String();
		
		String sqlcode = new String("select Roomstate_id from Room where Room_id='"+vo.getRoomId()+"'");
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlcode.toString());

			while(rs.next()) {
				s=(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return s;
	} 

}
