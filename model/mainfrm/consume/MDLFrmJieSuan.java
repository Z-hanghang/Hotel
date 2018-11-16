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
	 * 查找入住信息中的信息
	 * @param vo
	 * @return
	 */
	public Vector findRoomMessage(ResideVO vo) {
		return jieSuanDAO.findResideMessage(vo);
	}
	/**
	 * 根据房间号查找房间消费信息
	 */
	public Vector findRoomConsume(ConsumeVO vo) {
		return jieSuanDAO.findConMessageByRoom(vo);
	}
	/**
	 * 插入一条结算信息
	 */
	public void insertAccoutMes(AccountVO vo) {
		jieSuanDAO.insertAccount(vo);
	}
	/**
	 * 更新入住信息
	 */
	public void updateResideMes(ResideVO vo) {
		jieSuanDAO.updateRuZhuMessage(vo);
	}
	/**
	 *更新房间商品消费信息
	 */
	public void updateRoomConsume(ConsumeVO vo) {
		jieSuanDAO.updateRoomConsume(vo);
	}
	/**
	 * 更改房间的房间状态
	 * 
	 * @param vo
	 */
	public void updateRoomState(RoomVO vo) {
		jieSuanDAO.updateRoomState(vo);
	}
	/**
	 * 更改顾客类型
	 */
	public void updateCustomerType(CustomerVO vo) {
		jieSuanDAO.updateCustomerType(vo);
	}
	/**
	 * 插入一条会员记录
	 */
	public void insertVip(CustomerVO vo) {
		jieSuanDAO.insertVIPMe(vo);
	}
	/**
	 * 更新一条会员信息
	 */
	public void updateVipMessage(CustomerVO vo) {
		jieSuanDAO.updateVIPMe(vo);
	}

}
