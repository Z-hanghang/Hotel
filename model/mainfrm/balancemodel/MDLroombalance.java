package model.mainfrm.balancemodel;

import java.util.Vector;

import dao.mainfrm.balanceDAO.roombalancedao;
import vo.mainfrm.ruzhucha.balancevo.roombalanceVO;


public class MDLroombalance {
	 private roombalancedao jiesuanDAO = new roombalancedao();
	 
	 public  Vector findNewsByMessage( roombalanceVO vo) {
		    return jiesuanDAO.findnewsbyMessage(vo);//����һ��ͨ���������Ϣ������Ϣ
	 }
	 public Vector findAllNews(roombalanceVO vo) {
		    return jiesuanDAO.findallnews(vo);//�������������Ϣ�ķ���
		  }

}
