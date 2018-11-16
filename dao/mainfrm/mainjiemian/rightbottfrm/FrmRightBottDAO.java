package dao.mainfrm.mainjiemian.rightbottfrm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import vo.mainfrm.ConsumeVO;
import vo.mainfrm.ResideVO;
/**
 * ��ѯ���������������Ϣ ���������У�һ���ֲ�ѯ��������۸���Ϣ��
 *�ڶ����ֲ�ѯ������Ʒ������� ������ж�����������������һ������Ϣ�ظ���ʾ
 * @author �Ⱒ��
 *
 */
public class FrmRightBottDAO {
	
	/**
	 *��ѯ���������������Ϣ ���������У�һ���ֲ�ѯ��������۸���Ϣ��
	 *�ڶ����ֲ�ѯ������Ʒ������� ������ж�����������������һ������Ϣ�ظ���ʾ
	 * @param vo1
	 * @return
	 */
	public Vector findRoomConsume(ResideVO vo1) {
		Vector resultVector = new Vector();
		Object[] obj = new Object[4];
		
		String sql = new String("select re.Reside_id,re.Room_id,rt.Roomtype_piece,re.Deposit"
				+ " from Reside re,Roomtype rt where rt.Roomtype_id=(select re.Roomtype_id from Reside re where re.room_id='"+vo1.getRoomID()
				+"' and re.Room_id='"+vo1.getRoomID()+"' and Checkout_state='0')"); 
		
		String sqlcode = new String("select fd.Food_name,cos.Consume_number,cos.Consume_date,cos.Consume_count "
				+ "from Consume cos,Food fd where cos.Food_id=fd.Food_id and cos.Room_id='"+vo1.getRoomID()+"' and cos.Consume_state='0'");
		
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {                                 //��������۸���Ϣ
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				obj[0]=(rs.getString(1));
				obj[1]=(rs.getString(2));
				obj[2]=(rs.getString(3));
				obj[3]=(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(obj[0]!=null && !obj[0].equals("")) {
			try {
				st = conn.createStatement();
				rs=st.executeQuery(sqlcode); 
				while(rs.next()) {                //������Ʒ������Ϣ
					Vector v = new Vector();
					v.add(obj[0]);
					v.add(obj[1]);
					v.add(obj[2]);
					v.add(obj[3]);
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));
					v.add(rs.getString(4));
					
					resultVector.add(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();				
			}finally {
			      DBManager.free(conn, st, rs);
		    }
		}else {
			Vector v = new Vector();
			resultVector.add(v);
		}			
		return resultVector;		
	}
}
