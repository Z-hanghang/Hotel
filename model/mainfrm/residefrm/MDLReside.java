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
 * 登记入住部分的业务逻辑
 * @author 陈浩
 *
 */
public class MDLReside {
	private ResideFrmDAO resideDAO = new ResideFrmDAO();

	private Customerdao customerDAO = new Customerdao();
	
	private RoomDAO roomDAO = new RoomDAO();
	
	private ChangeRoomFrmDAO changeRoomFrmDAO = new ChangeRoomFrmDAO(); // 更改房间状态dao
	/**
	 * 根据vipID查找顾客信息
	 * @param vo   VIPVO
	 * @return
	 */
	public Vector findCustomerByVIP(CustomerVO vo) {
		return resideDAO.findCustomerByVIP(vo);
	}
	/**
	 * 根据用户电话查询顾客信息
	 * @param vo
	 * @return
	 */
	public Vector findCustomerByTel(CustomerVO vo) {
		return resideDAO.findCustomerByTel(vo);
	}
	/**
	 * 咋预定信息表中查询顾客信息
	 * @param vo
	 * @return
	 */
	public Vector findCustomerByReserve(ReserveVO vo) {
		return resideDAO.findReserveMessage(vo);
	}
	/**
	 * 根据房间类型房间状态查找房间
	 * @param type
	 * @param sqlProviso
	 * @return
	 */
	public Vector findRoomBytype(String type,String sqlProviso) {
		return roomDAO.findRoom(type, sqlProviso);
	}
	/**
	 * 插入一条顾客信息
	 * @param vo
	 */
	public void insertCustomer(CustomerVO vo) {
		customerDAO.insertCustomer(vo);
		}
	/**
	 * 插入一条入住信息
	 * @param vo
	 */
	public void insertReside(ResideVO vo) {
		resideDAO.insertReside(vo);
	}
	/**
	 * 更改房间状态
	 */
	public void updateRoomState(RoomVO vo) {
		changeRoomFrmDAO.updateRoomState(vo);
	}
	/**
	 * 更改预订表的信息
	 */
	public void updateReserve(ReserveVO vo) {
		resideDAO.updateReserve(vo);
	}
	/**
	 * 更改入住表中的退房时间
	 */
	public void updateResideLTime(ResideVO vo) {
		resideDAO.updateResideTime(vo);
	}
	/**
	 * 查询退房时间
	 */
	public String findTuiRoomTime(ResideVO vo) {
		return resideDAO.findResideLtime(vo);
	}
}
