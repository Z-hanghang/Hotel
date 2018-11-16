package dao.mainback.bianhao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.jdbc.DBManager;
import vo.mainback.Employee;
/*
 * 编号查询
 * 
 * **/
import vo.mainback.Roomvo;

public class NumberUp {
	
	
	//获取最大员工编号
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
			// 释放对象资源
			DBManager.free(conn, ps, rs);

		}
		return em;
	}
	//获取房间类型最大编号
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
			// 释放对象资源
			DBManager.free(conn, ps, rs);

		}
		return room;
	}
	//获取房间最大编号 根据楼层分布
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
			// 释放对象资源
			DBManager.free(conn, ps, rs);

		}
		return room;
	}
	
}
