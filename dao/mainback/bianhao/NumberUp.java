package dao.mainback.bianhao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.jdbc.DBManager;
import vo.mainback.Employee;
/*
 * ��Ų�ѯ
 * 
 * **/
import vo.mainback.Roomvo;

public class NumberUp {
	
	
	//��ȡ���Ա�����
	public Employee employeeMaxId(){
		Employee em=new Employee();
		String sql = "select max(Employee_Id) from Employee";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;	
		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				em.setEmployeeId(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷŶ�����Դ
			DBManager.free(conn, ps, rs);

		}
		return em;
	}
	//��ȡ�������������
	public Roomvo RoomTypeMaxId(){
		Roomvo  room=new  Roomvo ();
		String sql = "select max(roomtype_id) from roomtype";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;	
		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				room.setRoomtypeid(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷŶ�����Դ
			DBManager.free(conn, ps, rs);

		}
		return room;
	}
	//��ȡ��������� ����¥��ֲ�
	public Roomvo RoomMaxId(String s){
		Roomvo  room=new  Roomvo ();
		String sql = "select MAX(room_id) from room where floor_id='"+s+"'";
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;	
		conn = DBManager.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				room.setRoomid(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// �ͷŶ�����Դ
			DBManager.free(conn, ps, rs);

		}
		return room;
	}
	
}
