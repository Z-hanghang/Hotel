package model.mainfrm.mainjiemian.rightbottfrm;

import java.util.Vector;
import dao.mainfrm.mainjiemian.rightbottfrm.FrmRightBottDAO;
import dao.mainfrm.mainjiemian.righttopfrm.RoomTypeDAO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * ���·���ҵ���߼�����
 * @author �Ⱒ��
 */
public class MDLFrmRightBott {
	private FrmRightBottDAO frmRightBottDAO = new FrmRightBottDAO();
	private RoomTypeDAO roomTypeDAO = new RoomTypeDAO();
	// ���ҷ������ѵ���Ϣ
	public Vector findRoomConsumMessage(ResideVO vo1) {
		return frmRightBottDAO.findRoomConsume(vo1);
	}
	// ����һ������ķ���״̬
	public String findOneRoomState(RoomVO vo) {
		return roomTypeDAO.findOneRoomState(vo);
	}
}
