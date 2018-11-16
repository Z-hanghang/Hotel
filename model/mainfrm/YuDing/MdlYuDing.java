package model.mainfrm.YuDing;

import java.util.Vector;


import dao.mainfrm.RuZhu.ResideFrmDAO;
import dao.mainfrm.YuDing.JdbcYuDing;
import vo.mainfrm.CustomerVO;
import vo.mainfrm.ReserveVO;

/**
 * 预订增删查改逻辑业务处理
 * @author 张航
 * @date 2018.10.31
 * **/
public class MdlYuDing {
	private JdbcYuDing yd=new JdbcYuDing();
	private ResideFrmDAO rd=new ResideFrmDAO();
	//查询所有预订信息
	public Vector selectAllYuDing(){
		return yd.selectAllYuDing();
	}
	//根据预订状态查询预订信息
	public Vector selectYuDingSate(ReserveVO vo){
		return yd.selectYuDingSate(vo);
	}
	// 根据房间id查预订信息	public Vector selectYuDingRoom(ReserveVO vo){
		return yd.selectYuDingRoom(vo);
	}
	// 根据顾客姓名查预订信息
	public Vector selectYuDingCustomer(ReserveVO vo){
		return yd.selectYuDingCustomer(vo);
	}
	// 根据顾客电话查预订信息
	public Vector selectYuDingCustomerTel(ReserveVO vo){
		return yd.selectYuDingTel(vo);
	}
	//删除预订信息
	public void deleteYuDing(ReserveVO vo){
		 yd.deleteYuDing(vo);
	}
	//添加预订信息
	public void addYuDing(ReserveVO vo){
		yd.insertYuDing(vo);
	}
	//跟新预订信息
	public void updateYuDing(ReserveVO vo){
		yd.UpdateYuDing(vo);
	}
	//通过vipid查历史顾客
	public CustomerVO findCustomerByVIP(CustomerVO vo){
		return rd.findCustomerByVIP(vo);
	}
	//通过电话查历史顾客
	public Vector findCustomerByTel(CustomerVO vo){
		return rd.findCustomerByTel(vo);
	}
	//查找vip
	public String  findVipId(String y) {
		return yd.findVipId(y);
	}
	
	  //新增客户信息 
	public void xinZengCustomer(CustomerVO vo) {
	   yd.insertCustomer(vo);
	  }
	//查找历史顾客的编号和顾客类型编号
	 public CustomerVO findCustomerIDByTel(CustomerVO vo){
		 return yd.findCustomerByTel(vo);
	 }
	 ////根据预订编号更改预订状态
	 public void UpdateYuDingState(ReserveVO vo) {
		 yd.UpdateYuDingState(vo);
	 }
	 
}
