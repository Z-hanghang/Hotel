package model.mainfrm.residefrm;

import java.util.Vector;

import dao.mainfrm.changeroomfrm.ChangeRoomFrmDAO;
import dao.mainfrm.customer.Customerdao;
import dao.mainfrm.mainjiemian.righttopfrm.RoomDAO;
import dao.mainfrm.reside.ResideFrmDAO;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ReserveVO;
import vo.mainfrm.ResideVO;
import vo.mainfrm.RoomVO;
/**
 * �Ǽ���ס���ֵ�ҵ���߼�
 * @author �º�
 *
 */
public class MDLReside {
	private ResideFrmDAO resideDAO = new ResideFrmDAO();

	private Customerdao customerDAO = new Customerdao();
	
	private RoomDAO roomDAO = new RoomDAO();
	
	private ChangeRoomFrmDAO changeRoomFrmDAO = new ChangeRoomFrmDAO(); // ���ķ���״̬dao
	/**
	 * ����vipID���ҹ˿���Ϣ
	 * @param vo   VIPVO
	 * @return
	 */
	public Vector findCustomerByVIP(CustomerVO vo) {
		return resideDAO.findCustomerByVIP(vo);
	}
	/**
	 * �����û��绰��ѯ�˿���Ϣ
	 * @param vo
	 * @return
	 */
	public Vector findCustomerByTel(CustomerVO vo) {
		return resideDAO.findCustomerByTel(vo);
	}
	/**
	 * զԤ����Ϣ���в�ѯ�˿���Ϣ
	 * @param vo
	 * @return
	 */
	public Vector findCustomerByReserve(ReserveVO vo) {
		return resideDAO.findReserveMessage(vo);
	}
	/**
	 * ���ݷ������ͷ���״̬���ҷ���
	 * @param type
	 * @param sqlProviso
	 * @return
	 */
	public Vector findRoomBytype(String type,String sqlProviso) {
		return roomDAO.findRoom(type, sqlProviso);
	}
	/**
	 * ����һ���˿���Ϣ
	 * @param vo
	 */
	public void insertCustomer(CustomerVO vo) {
		customerDAO.insertCustomer(vo);
		}
	/**
	 * ����һ����ס��Ϣ
	 * @param vo
	 */
	public void insertReside(ResideVO vo) {
		resideDAO.insertReside(vo);
	}
	/**
	 * ���ķ���״̬
	 */
	public void updateRoomState(RoomVO vo) {
		changeRoomFrmDAO.updateRoomState(vo);
	}
	/**
	 * ����Ԥ�������Ϣ
	 */
	public void updateReserve(ReserveVO vo) {
		resideDAO.updateReserve(vo);
	}
	/**
	 * ������ס���е��˷�ʱ��
	 */
	public void updateResideLTime(ResideVO vo) {
		resideDAO.updateResideTime(vo);
	}
	/**
	 * ��ѯ�˷�ʱ��
	 */
	public String findTuiRoomTime(ResideVO vo) {
		return resideDAO.findResideLtime(vo);
	}
}
