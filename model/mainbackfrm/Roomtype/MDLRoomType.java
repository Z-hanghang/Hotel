package model.mainbackfrm.Roomtype;


import java.util.HashSet;
import java.util.Vector;

import dao.mainback.RoomType.JdbcRoomType;
import vo.mainback.Roomvo;
/**
 * 房间类型业务逻辑
 * */
public class MDLRoomType {
	private JdbcRoomType roomtypedao= new JdbcRoomType();
	    //添加房间类型
	    public void  AddRoomType(Roomvo vo) {
	      this.roomtypedao.insertRoomType(vo);
	    }
	    //修改房间类型
	      public void UpdateRoomType(Roomvo vo) {
	      this.roomtypedao.updateRoomTypeByPK(vo);
	     }
	     //查询全部房间类型
	     public Vector SelectAllRoom() {
		    return roomtypedao.findAllRoomType();
		  }
	     //根据价格查类型 
	     public Vector SelectRoomPrice(String s1,String s2) {
	    	 return roomtypedao.findRoomTypeByRoomTypepiece(s1, s2);
	     }
	     //根据类型名称查找房间类型
	     public Vector SelectRoomTypeName(Roomvo vo) {
			    return roomtypedao.findRoomTypeByRoomTypename(vo);
			  }
	     //删除房间类型
		  public void DeleteRoomType(Roomvo vo) {
			  roomtypedao.deleteRoomTypeByPK(vo);
		  }
		  //查询所有房间类型名
		  public Vector<String> selectAllRoomTypeName(){
			  return roomtypedao.SelectAllRoomTypeName();
		  }
		  //根据房间 类型名查找房间编号
		  public String SelectRoomTypeID(String RoomTypeName) {
			  return roomtypedao.SelectRoomTypeID(RoomTypeName);
		  }
		 
}
