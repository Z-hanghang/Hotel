package model.mainfrm.mainjiemian.rightbottfrm;

import java.util.Vector;
import dao.mainfrm.mainjiemian.rightbottfrm.FrmRightBottDAO;
import dao.mainfrm.mainjiemian.righttopfrm.RoomTypeDAO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * 右下方的业务逻辑方法
 * @author 吴阿龙
 */
public class MDLFrmRightBott {
	private FrmRightBottDAO frmRightBottDAO = new FrmRightBottDAO();
	private RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
	// 查找房间消费的信息
	public Vector findRoomConsumMessage(ResideVO vo1) {
		return frmRightBottDAO.findRoomConsume(vo1);
	}
	// 查找一个房间的房间状态
	public String findOneRoomState(RoomVO vo) {
		return roomTypeDAO.findOneRoomState(vo);
	}
}
