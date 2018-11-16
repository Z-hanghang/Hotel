package model.mainfrm.mainjiemian.lefttopfrm;

import java.util.Vector;

import dao.mainfrm.mainjiemian.leftbottfrm.PanDuanExitsDAO;
import dao.mainfrm.mainjiemian.lefttopfrm.ResideDAO;
import dao.mainfrm.mainjiemian.righttopfrm.RoomDAO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * 左边面板的业务逻辑
 * 功能： 用于房间状态数量的统计，房间信息的显示，房间是否在数据库中存在
 * @author 吴阿龙
 *
 */
public class MDLFrmLeftTop {
	private RoomDAO roomDAO = new RoomDAO();
	private ResideDAO resideDAO = new ResideDAO();
	private PanDuanExitsDAO panDuanExitsDAO = new PanDuanExitsDAO();
	//查找房间数量
	public String[] findRoomCount(RoomVO vo) {
		return roomDAO.findRoomCount(vo);	
	}
	//查找房间入住信息
	public Vector findResideMessage(ResideVO vo1,CustomerVO vo2) {
		return resideDAO.findResideMessage(vo1, vo2);
	}
	//查看房间是否存在
	public boolean findRoomExits(RoomVO vo) {
		return panDuanExitsDAO.findRoomExits(vo);
	}

}
