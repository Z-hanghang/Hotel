package dao.mainfrm.mainjiemian.leftbottfrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.RoomVO;
/**
 * �ڻ�ȡ�ķ�����ڷ�����Ϣ�����ж��Ƿ���ڸ÷����
 * @author �Ⱒ��
 *
 */
public class PanDuanExitsDAO {
	/**
	 * ���ڻ�ȡ�ķ�����ڷ�����Ϣ�����ж��Ƿ���ڸ÷����
	 * @param vo
	 * @return
	 */
	public boolean findRoomExits(RoomVO vo) {
		Vector v = new Vector();
		boolean b = false;
		String sql = new String("select Room_id from Room where Room_id='"+vo.getRoomId()+"'");
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			while(rs.next()){
				v.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(v.size()!=0) {
			b=true;
		}
		return b;
	}

}
