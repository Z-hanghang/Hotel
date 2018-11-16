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
 * 根据房间号查找出房间的信息和顾客的信息，主要用于左上方房间信息显示面板的使用
 * @author 吴阿龙
 *
 */
public class ResideDAO {
	/**
	 * 根据房间号查找出房间的信息和顾客的信息，主要用于左上方面板的使用
	 * @param vo1   预定信息表
	 * @param vo2  顾客信息表
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
