package model.mainfrm.changeroomfrm;

import java.util.Iterator;
import java.util.Vector;

import dao.mainfrm.changeroomfrm.ChangeRoomFrmDAO;
import vo.mainfrm.CsrecordVO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomTypeVO;
import vo.mainfrm.RoomVO;
/**
 * 更换房间的业务逻辑
 * @author Administrator
 *
 */
public class MDLChangeRoom {
	private ChangeRoomFrmDAO changeRoomFrmDAO = new ChangeRoomFrmDAO();
	/**
	 * 查找同类型为入住的房间
	 */
	public Vector findAllSameRoom(RoomTypeVO vo) {
		return changeRoomFrmDAO.FindSameTypeRoom(vo);	
	}
	/**
	 *  更改入住信息表
	 */
	public void updateReside(ResideVO vo,String newRoom) {
		changeRoomFrmDAO.updateReside(vo, newRoom);
	}
	/**
	 *  更改对应房间状态
	 */
	public void updateRoomState(RoomVO vo) {
		changeRoomFrmDAO.updateRoomState(vo);
	}
	/**
	 * 插入换房记录信息
	 */
	public void insertCsrecord(CsrecordVO vo) {
		changeRoomFrmDAO.insertCsrecord(vo);
	}
	/**
	 * 查找对应入住房间顾客id
	 */
	public String findCustomerId(ResideVO vo) {
		return changeRoomFrmDAO.findCustomerId(vo);
	}


}
