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
 * ���������ҵ���߼�
 * @author Administrator
 *
 */
public class MDLChangeRoom {
	private ChangeRoomFrmDAO changeRoomFrmDAO = new ChangeRoomFrmDAO();
	/**
	 * ����ͬ����Ϊ��ס�ķ���
	 */
	public Vector findAllSameRoom(RoomTypeVO vo) {
		return changeRoomFrmDAO.FindSameTypeRoom(vo);	
	}
	/**
	 *  ������ס��Ϣ��
	 */
	public void updateReside(ResideVO vo,String newRoom) {
		changeRoomFrmDAO.updateReside(vo, newRoom);
	}
	/**
	 *  ���Ķ�Ӧ����״̬
	 */
	public void updateRoomState(RoomVO vo) {
		changeRoomFrmDAO.updateRoomState(vo);
	}
	/**
	 * ���뻻����¼��Ϣ
	 */
	public void insertCsrecord(CsrecordVO vo) {
		changeRoomFrmDAO.insertCsrecord(vo);
	}
	/**
	 * ���Ҷ�Ӧ��ס����˿�id
	 */
	public String findCustomerId(ResideVO vo) {
		return changeRoomFrmDAO.findCustomerId(vo);
	}


}
