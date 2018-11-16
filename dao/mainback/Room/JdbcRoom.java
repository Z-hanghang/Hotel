package dao.mainback.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import common.jdbc.DBManager;
import common.jdbc.ExceptionChuLi;
import vo.mainback.Roomvo;
/**
 * ��ɾ��ķ�����Ϣ
 * @author �ź�
 * @date 2018.10.29
 * 
 * 
 * */
public class JdbcRoom {
	private StringBuilder sql=new StringBuilder("select  r.room_id,re.roomtype_name,re.roomtype_piece,r.room_number,r.floor_id  from room r,roomtype re  where r.roomtype_id=re.roomtype_id  ");
	//��ѯȫ������
	public Vector selectAllRoom(){
		return find(sql.toString());
	}
	//��ѯ����������
	public String selectRoomTypeId(Roomvo vo){
		String a=null;
		String s="select roomtype_id from roomtype  where  roomtype_name='"+vo.getRoomtypename()+"'";
	    Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(s);
			while (rs.next()) {
			String b=rs.getString(1);
			a=b;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return a;
	
	}
	//��������������ѯ
	public Vector selectRoomTypeName(Roomvo vo){
		String roomTypeName=vo.getRoomtypename();
		if(roomTypeName != null && !roomTypeName.equals("")){
			sql.append(" and  re.roomtype_name  like '%"+roomTypeName+"%'");
		}
		return find(sql.toString()); 		
	
	}
	//������Id��ѯ
	public Vector selectRoomId(Roomvo vo){
		String roomId=vo.getRoomid();
		if(roomId != null && !roomId.equals("")){
			sql.append(" and  r.room_id  like '%"+roomId+"%'");
		}
		return find(sql.toString()); 		
		
	}
	//ɾ������
	public void deleteRoom(Roomvo vo) {
		String sql = "delete room where room_id = '" + vo.getRoomid() + "'";

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
	
	/**
	 *  ͨ���������ͻ��߷���״̬��������ҳ���Ӧ�ķ����
	 * @param type   ��������id
	 * @param sqlProviso  ����״̬id
	 * @return
	 */
	public Vector findRoom(String type) {
		Vector resultVector = new Vector();

		StringBuilder sql = new StringBuilder("SELECT r.room_id FROM room r,roomtype re WHERE r.roomtype_id=re.roomtype_id ");
	    //System.out.println(sqlProviso);
		//sql.append("where Roomstate_id = (select Roomstate_id from Room where Roomtype_id='"+ type +"') and Roomtype_id='" + type + "' " + sqlProviso);
		
		
		if(type!=null&&!type.equals("")){
	   sql.append("   and re.Roomtype_name='"+ type +"' and r.roomstate_id='RS01'");
		}
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql.toString());
			//Vector v2 = new Vector();
			while (rs.next()) {
				String[] str=new String[1];
				str[0]=(rs.getString(1));
				resultVector.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultVector;
	}
	
	
	//���ӷ���
	public void insertRoom(Roomvo vo) {
		String sql = "insert into room values(?, ?, ?,?,?)";
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRoomid());
			ps.setString(2, vo.getRoomtypeid());
			ps.setDouble(3, vo.getRoomnumber());
			ps.setString(4, vo.getFloorid());
			//����Ĭ��Ϊ�յķ���״̬
			ps.setString(5, "RS01");

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, ps);
		}
	}
	
	// �޸ķ�����Ϣ
		public void updateRoom(Roomvo vo) {
			String sql = "update room set roomtype_id=?, room_number=?, floor_id=?, roomstate_id=?  where  room_id=?";
			Connection conn = DBManager.getConnection();
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getRoomtypeid());
				ps.setDouble(2, vo.getRoomnumber());
				ps.setString(3, vo.getFloorid());
				ps.setString(4, vo.getRoomstateid());
				ps.setString(5, vo.getRoomid());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.free(conn, ps);
			}
		}
	
		/**
		 * ���ķ���ķ���״̬
		 * 
		 * @param vo
		 */
		public void updateRoomState(Roomvo vo) {
			String sql = "update Room set Roomstate_id ='"+vo.getRoomstateid()+"' where Room_id='" + vo.getRoomid() + "'";
			Connection conn = DBManager.getConnection();
			PreparedStatement ps = null;
			// �ɷ���ķ���״̬
			try {
				// System.out.println(sql2);
				ps = conn.prepareStatement(sql);

				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// �·���ķ���״̬
			try {
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.free(conn, ps);
			}

		}

	
	//��ѯ����˽�з���
	private Vector find(String  sql) {
		Vector resultVector = new Vector();
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
				v.add(rs.getString(4));
				v.add(rs.getString(5));
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
	//���ҷ�������Id
	public String findRoomTypeID(String roomID){
		String string=null;
		String sql="select  r.roomtype_id from room r where r.room_id='"+roomID+"'";
		Connection conn = DBManager.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				string=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.free(conn, st, rs);
		}

		return string;
	}
	
	
}
