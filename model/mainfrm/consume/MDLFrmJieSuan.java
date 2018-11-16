package model.mainfrm.consume;

import java.util.Vector;

import dao.mainfrm.consume.JieSuanDao;
import vo.consumeaout.AccountVO;
import vo.consumeaout.ConsumeVO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;

public class MDLFrmJieSuan {
	private JieSuanDao jieSuanDAO = new JieSuanDao();
	/**
	 * ������ס��Ϣ�е���Ϣ
	 * @param vo
	 * @return
	 */
	public Vector findRoomMessage(ResideVO vo) {
		return jieSuanDAO.findResideMessage(vo);
	}
	/**
	 * ���ݷ���Ų��ҷ���������Ϣ
	 */
	public Vector findRoomConsume(ConsumeVO vo) {
		return jieSuanDAO.findConMessageByRoom(vo);
	}
	/**
	 * ����һ��������Ϣ
	 */
	public void insertAccoutMes(AccountVO vo) {
		jieSuanDAO.insertAccount(vo);
	}
	/**
	 * ������ס��Ϣ
	 */
	public void updateResideMes(ResideVO vo) {
		jieSuanDAO.updateRuZhuMessage(vo);
	}
	/**
	 *���·�����Ʒ������Ϣ
	 */
	public void updateRoomConsume(ConsumeVO vo) {
		jieSuanDAO.updateRoomConsume(vo);
	}
	/**
	 * ���ķ���ķ���״̬
	 * 
	 * @param vo
	 */
	public void updateRoomState(RoomVO vo) {
		jieSuanDAO.updateRoomState(vo);
	}
	/**
	 * ���Ĺ˿�����
	 */
	public void updateCustomerType(CustomerVO vo) {
		jieSuanDAO.updateCustomerType(vo);
	}
	/**
	 * ����һ����Ա��¼
	 */
	public void insertVip(CustomerVO vo) {
		jieSuanDAO.insertVIPMe(vo);
	}
	/**
	 * ����һ����Ա��Ϣ
	 */
	public void updateVipMessage(CustomerVO vo) {
		jieSuanDAO.updateVIPMe(vo);
	}

}
