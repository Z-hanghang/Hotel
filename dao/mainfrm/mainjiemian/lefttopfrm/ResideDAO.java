package dao.mainfrm.mainjiemian.lefttopfrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;
/**
 * ���ݷ���Ų��ҳ��������Ϣ�͹˿͵���Ϣ����Ҫ�������Ϸ�������Ϣ��ʾ����ʹ��
 * @author �Ⱒ��
 *
 */
public class ResideDAO {
	/**
	 * ���ݷ���Ų��ҳ��������Ϣ�͹˿͵���Ϣ����Ҫ�������Ϸ�����ʹ��
	 * @param vo1   Ԥ����Ϣ��
	 * @param vo2  �˿���Ϣ��
	 * @return
	 */
	public Vector findResideMessage(ResideVO vo1,CustomerVO vo2) {
		Vector resuleVector = new Vector();
		
		StringBuilder sql = new StringBuilder("select cut.Customer_name,cut.Customer_tel,cut.Customer_sex,"
				+ "re.Room_id,re.Reside_number,re.Reside_rtime,re.Deposit,re.Employee_id from Reside re,Customer cut ");
		sql.append("where re.Customer_id=cut.Customer_id and re.Room_id='"+vo1.getRoomID()+"' and Checkout_state='0'");
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			
			while(rs.next()) {
				resuleVector.add(rs.getString(1));
				resuleVector.add(rs.getString(2));
				resuleVector.add(rs.getString(3));
				resuleVector.add(rs.getString(4));
				resuleVector.add(rs.getString(5));
				resuleVector.add(rs.getString(6));
				resuleVector.add(rs.getString(7));
				resuleVector.add(rs.getString(8));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resuleVector;
		
		
	}

}
