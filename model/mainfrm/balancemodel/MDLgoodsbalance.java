package model.mainfrm.balancemodel;

import java.util.Vector;

import dao.mainfrm.balanceDAO.goodsbalancedao;
import vo.mainfrm.ruzhucha.balancevo.goodsbalanceVO;

public class MDLgoodsbalance {
	 private goodsbalancedao shangpinjiesuanDAO = new goodsbalancedao();
	 
	 public  Vector findNewsBymessage( goodsbalanceVO vo) {
		    return shangpinjiesuanDAO.findnewsbymessage(vo);//定义一个通过输入框输入查找信息的方法
	 }
	 public Vector findAllNews(goodsbalanceVO vo) {
		    return shangpinjiesuanDAO.findallnews(vo);//定义一个查找所有信息的方法
	 }
//	 public  Vector FindNewsBystate( goodsbalanceVO vo) {
//		    return shangpinjiesuanDAO.findnewsbystate(vo);//定义一个通过结账状态查找所有信息的方法
//	 }
	 
}
