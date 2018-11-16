package model.mainbackfrm.room;

import java.util.Vector;

import dao.mainback.Room.JdbcRoom;
import vo.mainback.Roomvo;

/**
 * ҵ���߼� ���� ��ɾ���
 * 
 * @author �ź�
 * @date 2018.10.29
 * 
 **/
public class mdlRoom {
	private JdbcRoom jm = new JdbcRoom();

	// ��ѯ���з���
	public Vector selectAllRoom() {
		return jm.selectAllRoom();
	}

	// ���ݷ������Ͳ���
	public Vector selectRoomTypeName(Roomvo vo) {
		return jm.selectRoomTypeName(vo);
	}

	// ���ݷ���Ų���
	public Vector selectRoomId(Roomvo vo) {
		return jm.selectRoomId(vo);
	}

	// ���ӷ���
	public void addRoom(Roomvo vo) {
		jm.insertRoom(vo);
	}

	// ɾ������
	public void deleteRoom(Roomvo vo) {
		jm.deleteRoom(vo);
	}

	// �޸ķ���
	public void updateRoom(Roomvo vo) {
		jm.updateRoom(vo);
	}
	//��ѯ����������
	public String selectRoomTypeId(Roomvo vo) {
		return jm.selectRoomTypeId(vo);
	}
	//���ķ���״̬
	public void updateRoomSate(Roomvo vo){
		jm.updateRoomState(vo);
	}
	//ͨ���������Ͳ��ҷ����
	public Vector findRoomByRoomState(String type){
		return jm.findRoom(type);
	}
	//���ݷ���ŷ�������Id
	public String findRoomTypeID(String  roomID) {
		return jm.findRoomTypeID(roomID);
	}
	
}
