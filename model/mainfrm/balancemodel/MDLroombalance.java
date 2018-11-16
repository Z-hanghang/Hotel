package model.mainfrm.balancemodel;

import java.util.Vector;

import dao.mainfrm.balanceDAO.roombalancedao;
import vo.mainfrm.ruzhucha.balancevo.roombalanceVO;


public class MDLroombalance {
	 private roombalancedao jiesuanDAO = new roombalancedao();
	 
	 public  Vector findNewsByMessage( roombalanceVO vo) {
		    return jiesuanDAO.findnewsbyMessage(vo);//定义一个通过输入框信息查找信息
	 }
	 public Vector findAllNews(roombalanceVO vo) {
		    return jiesuanDAO.findallnews(vo);//定义查找所有信息的方法
		  }

}
