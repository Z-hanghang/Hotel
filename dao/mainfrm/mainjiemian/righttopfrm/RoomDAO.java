package dao.mainfrm.mainjiemian.righttopfrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.RoomTypeVO;
import vo.mainfrm.RoomVO;

/**
 * ͨ���������ͻ��߷���״̬��������ҳ���Ӧ�ķ����
 * 
 * @author �Ⱒ��
 *
 */
public class RoomDAO {
	/**
	 * ͨ���������ͻ��߷���״̬��������ҳ���Ӧ�ķ����
	 * 
	 * @param type
	 *            ��������id
	 * @param sqlProviso
	 *            ����״̬id
	 * @return
	 */
	public Vector findRoom(String type, String sqlProviso) {
		Vector resultVector = new Vector();

		StringBuilder sql = new StringBuilder("select Room_id,Roomstate_id from Room ");
		// System.out.println(sqlProviso);
		// sql.append("where Roomstate_id = (select Roomstate_id from Room where
		// Roomtype_id='"+ type +"') and Roomtype_id='" + type + "' " + sqlProviso);
//		String typestr = type.substring(0, 2);
		// System.out.println(typestr);
		sql.append("where  Roomtype_id='" + type + "' " + sqlProviso);
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			// Vector v2 = new Vector();
			while (rs.next()) {
				String[] str = new String[2];
				str[0] = (rs.getString(1));
				str[1] = (rs.getString(2));

				resultVector.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultVector;
	}

	/**
	 * ͨ�������״̬���ҳ����������
	 * 
	 * @param vo
	 *            ����vo����
	 * @return
	 */
	public String[] findRoomCount(RoomVO vo) {
		String[] resultCount = new String[1];

		StringBuilder sql = new StringBuilder("select count(*) from Room ");
		sql.append("where  Roomstate_id like '%" + vo.getRoomStateId() + "%'");

		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			// System.out.println(sql);
			rs = st.executeQuery(sql.toString());

			while (rs.next()) {
				resultCount[0] = (rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCount;

	}

	// public static void main(String[] args) {
	// RoomVO vo = new RoomVO();
	// Vector v = findRoomType(vo);
	// for (Iterator iterator = v.iterator(); iterator.hasNext();) {
	// String str = (String) iterator.next();
	// System.out.println(str);
	// }
	// }
}
