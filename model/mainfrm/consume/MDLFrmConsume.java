package model.mainfrm.consume;

import java.util.Vector;

import dao.mainfrm.consume.ConsumeFrmDao;
import vo.consumeaout.ConsumeVO;
import vo.consumeaout.FoodVO;
import vo.consumeaout.FoodstockVO;
import vo.consumeaout.ResideVO;


public class MDLFrmConsume {

	private ConsumeFrmDao consumeDAO = new ConsumeFrmDao();

	// ���ݷ���Ų�ѯ��ס��Ϣ
	public Vector ruZhu(ResideVO vo) {
		return consumeDAO.ruZhuMessage(vo);
	}

	// ����������Ҷ�Ӧ����Ʒ
	public Vector<Vector> chaZhaoShangPin(FoodVO vo) {
		return consumeDAO.findShangPinByShangPinMing(vo);
	}

	// ����������Ʒ
	public Vector<Vector> chaZhaoAllShangPin(FoodVO vo) {
		return consumeDAO.findShangPinByShangPinMing(vo);
	}
	
	// ���ݷ��Ų�ѯ��ǰ������Ϣ
	public Vector findRoomConsumeMe(ConsumeVO vo) {
		return consumeDAO.findRoomConsume(vo);
	}
	//���ݷ���Ų�ѯ�˿ͱ��
	public String findCustomerM(ResideVO vo) {
		return consumeDAO.findCustomerM(vo);
	}
	
	//������Ʒ����ѯ��Ʒ���
	public String findFoodId(FoodVO vo) {
		return consumeDAO.findFoodId(vo);
	}
	//���·���������Ϣ��
	public void updateConsume(ConsumeVO vo) {
		consumeDAO.updateConsume(vo);
	}
	
	//���뷿��������Ϣ��
	public void insertConsume(ConsumeVO vo) {
		consumeDAO.insertConsume(vo);
	}
	
	//������Ʒ���
	public void updateFoodStock(FoodVO vo1,FoodstockVO vo2) {
		consumeDAO.updateFoodstock(vo1, vo2);
	}
}
