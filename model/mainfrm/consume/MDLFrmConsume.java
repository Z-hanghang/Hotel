package model.mainfrm.consume;

import java.util.Vector;

import dao.mainfrm.consume.ConsumeFrmDao;
import vo.consumeaout.ConsumeVO;
import vo.consumeaout.FoodVO;
import vo.consumeaout.FoodstockVO;
import vo.consumeaout.ResideVO;


public class MDLFrmConsume {

	private ConsumeFrmDao consumeDAO = new ConsumeFrmDao();

	// 根据房间号查询入住信息
	public Vector ruZhu(ResideVO vo) {
		return consumeDAO.ruZhuMessage(vo);
	}

	// 根据输入查找对应的商品
	public Vector<Vector> chaZhaoShangPin(FoodVO vo) {
		return consumeDAO.findShangPinByShangPinMing(vo);
	}

	// 查找所有商品
	public Vector<Vector> chaZhaoAllShangPin(FoodVO vo) {
		return consumeDAO.findShangPinByShangPinMing(vo);
	}
	
	// 根据房号查询以前消费信息
	public Vector findRoomConsumeMe(ConsumeVO vo) {
		return consumeDAO.findRoomConsume(vo);
	}
	//根据房间号查询顾客编号
	public String findCustomerM(ResideVO vo) {
		return consumeDAO.findCustomerM(vo);
	}
	
	//根据商品名查询商品编号
	public String findFoodId(FoodVO vo) {
		return consumeDAO.findFoodId(vo);
	}
	//更新房间消费信息表
	public void updateConsume(ConsumeVO vo) {
		consumeDAO.updateConsume(vo);
	}
	
	//插入房间消费信息表
	public void insertConsume(ConsumeVO vo) {
		consumeDAO.insertConsume(vo);
	}
	
	//更新商品库存
	public void updateFoodStock(FoodVO vo1,FoodstockVO vo2) {
		consumeDAO.updateFoodstock(vo1, vo2);
	}
}
