package model.mainbackfrm.room;

import java.util.Vector;

import dao.mainback.Room.JdbcRoom;
import vo.mainback.Roomvo;

/**
 * 业务逻辑 房间 增删查改
 * 
 * @author 张航
 * @date 2018.10.29
 * 
 **/
public class mdlRoom {
	private JdbcRoom jm = new JdbcRoom();

	// 查询所有房间
	public Vector selectAllRoom() {
		return jm.selectAllRoom();
	}

	// 根据房间类型查找
	public Vector selectRoomTypeName(Roomvo vo) {
		return jm.selectRoomTypeName(vo);
	}

	// 根据房间号查找
	public Vector selectRoomId(Roomvo vo) {
		return jm.selectRoomId(vo);
	}

	// 增加房间
	public void addRoom(Roomvo vo) {
		jm.insertRoom(vo);
	}

	// 删除房间
	public void deleteRoom(Roomvo vo) {
		jm.deleteRoom(vo);
	}

	// 修改房间
	public void updateRoom(Roomvo vo) {
		jm.updateRoom(vo);
	}
	//查询房间类型名
	public String selectRoomTypeId(Roomvo vo) {
		return jm.selectRoomTypeId(vo);
	}
	//更改房间状态
	public void updateRoomSate(Roomvo vo){
		jm.updateRoomState(vo);
	}
	//通过房间类型查找房间号
	public Vector findRoomByRoomState(String type){
		return jm.findRoom(type);
	}
	//根据房间号房间类型Id
	public String findRoomTypeID(String  roomID) {
		return jm.findRoomTypeID(roomID);
	}
	
}
