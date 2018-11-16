package model.mainfrm.mainjiemian.lefttopfrm;

import java.util.Vector;

import dao.mainfrm.mainjiemian.leftbottfrm.PanDuanExitsDAO;
import dao.mainfrm.mainjiemian.lefttopfrm.ResideDAO;
import dao.mainfrm.mainjiemian.righttopfrm.RoomDAO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

/**
 * �������ҵ���߼�
 * ���ܣ� ���ڷ���״̬������ͳ�ƣ�������Ϣ����ʾ�������Ƿ������ݿ��д���
 * @author �Ⱒ��
 *
 */
public class MDLFrmLeftTop {
	private RoomDAO roomDAO = new RoomDAO();
	private ResideDAO resideDAO = new ResideDAO();
	private PanDuanExitsDAO panDuanExitsDAO = new PanDuanExitsDAO();
	//���ҷ�������
	public String[] findRoomCount(RoomVO vo) {
		return roomDAO.findRoomCount(vo);	
	}
	//���ҷ�����ס��Ϣ
	public Vector findResideMessage(ResideVO vo1,CustomerVO vo2) {
		return resideDAO.findResideMessage(vo1, vo2);
	}
	//�鿴�����Ƿ����
	public boolean findRoomExits(RoomVO vo) {
		return panDuanExitsDAO.findRoomExits(vo);
	}

}
