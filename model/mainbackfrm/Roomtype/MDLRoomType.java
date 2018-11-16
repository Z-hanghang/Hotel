package model.mainbackfrm.Roomtype;


import java.util.HashSet;
import java.util.Vector;

import dao.mainback.RoomType.JdbcRoomType;
import vo.mainback.Roomvo;
/**
 * ��������ҵ���߼�
 * */
public class MDLRoomType {
	private JdbcRoomType roomtypedao= new JdbcRoomType();
	    //��ӷ�������
	    public void  AddRoomType(Roomvo vo) {
	      this.roomtypedao.insertRoomType(vo);
	    }
	    //�޸ķ�������
	      public void UpdateRoomType(Roomvo vo) {
	      this.roomtypedao.updateRoomTypeByPK(vo);
	     }
	     //��ѯȫ����������
	     public Vector SelectAllRoom() {
		    return roomtypedao.findAllRoomType();
		  }
	     //���ݼ۸������ 
	     public Vector SelectRoomPrice(String s1,String s2) {
	    	 return roomtypedao.findRoomTypeByRoomTypepiece(s1, s2);
	     }
	     //�����������Ʋ��ҷ�������
	     public Vector SelectRoomTypeName(Roomvo vo) {
			    return roomtypedao.findRoomTypeByRoomTypename(vo);
			  }
	     //ɾ����������
		  public void DeleteRoomType(Roomvo vo) {
			  roomtypedao.deleteRoomTypeByPK(vo);
		  }
		  //��ѯ���з���������
		  public Vector<String> selectAllRoomTypeName(){
			  return roomtypedao.SelectAllRoomTypeName();
		  }
		  //���ݷ��� ���������ҷ�����
		  public String SelectRoomTypeID(String RoomTypeName) {
			  return roomtypedao.SelectRoomTypeID(RoomTypeName);
		  }
		 
}
